package com.semenov.moexstocks.parser

import com.semenov.moexstocks.dto.BondDto
import com.semenov.moexstocks.exception.BondParsingException
import java.io.StringReader
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource


@Service
class MoexBondXmlParser : Parser {
    override fun parse(ratesAsString: String): List<BondDto> {
        val bonds = ArrayList<BondDto>()
        val dbf = DocumentBuilderFactory.newInstance()
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
            val db = dbf.newDocumentBuilder()
            StringReader(ratesAsString).use { reader ->
                val doc: Document = db.parse(InputSource(reader))
                doc.getDocumentElement().normalize()
                val list: NodeList = doc.getElementsByTagName("row")
                for (rowIdx in 0 until list.getLength()) {
                    val node: Node? = list.item(rowIdx)
                    if (node?.nodeType == Node.ELEMENT_NODE) {
                        val element: Element = node as Element
                        val ticker: String = element.getAttribute("SECID")
                        val price: String = element.getAttribute("PREVADMITTEDQUOTE")
                        val name: String = element.getAttribute("SHORTNAME")
                        if (ticker.isNotEmpty() && price.isNotEmpty() && name.isNotEmpty()) {
                            bonds.add(BondDto(ticker, name, price.toDouble()))
                        }
                    }
                }
            }
        } catch (ex: Exception) {
            LOG.error("xml parsing error, xml: $ratesAsString", ex)
            throw BondParsingException(ex.message)
        }
        return bonds
    }

    companion object {
        val LOG = KotlinLogging.logger() {}
    }
}