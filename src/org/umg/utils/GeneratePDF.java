package org.umg.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.umg.bean.CartItem;
import org.umg.bean.Compra;
import org.umg.manejador.ManejadorCompra;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class GeneratePDF {
	
	public static GeneratePDF INSTANCIA = new GeneratePDF();
	
	private String idFactura = "";
	
	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	static Compra item = new Compra();
 
	/**
	 * @param args
	 */
	public static Document createPDF(String file) {
		item = ManejadorCompra.INSTANCIA.getCompraUsuario(GeneratePDF.INSTANCIA.getIdFactura());
		
		Document document = null;
 
		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
 
			addMetaData(document);
 
			addTitlePage(document);
 
			createTable(document);
			
			addFooter(document);
 
			document.close();
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
 
	}
 
	private static void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");
	}
 
	private static void addTitlePage(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Factura", TIME_ROMAN));
 
		creteEmptyLine(preface, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		preface.add(new Paragraph("No Factura: " + item.getNoFactura(), TIME_ROMAN_SMALL));
		preface.add(new Paragraph("Fecha: " + simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		preface.add(new Paragraph("Nombre: " + item.getNombre(), TIME_ROMAN_SMALL));
		preface.add(new Paragraph("Nit: " + item.getNit(), TIME_ROMAN_SMALL));
		preface.add(new Paragraph("Direccion: " + item.getDireccion(), TIME_ROMAN_SMALL));
		document.add(preface);
 
	}
	
	private static void addFooter(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1); 
		creteEmptyLine(preface, 1);

		preface.add(new Paragraph("Total: Q." + item.getTotal(), TIME_ROMAN_SMALL));
		document.add(preface);
 
	}
 
	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
 
	private static void createTable(Document document) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(3);
 
		PdfPCell c1 = new PdfPCell(new Phrase("Cantidad"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Nombre"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Precio"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
 
		for(CartItem item : GeneratePDF.item.getDetalle()) {
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(Integer.toString(item.getCantidad()));
			table.addCell(item.getProducto().getNombre());
			table.addCell("Q."+Float.toString(item.getProducto().getPrecio()));
		}
 
		document.add(table);
	}
 
}