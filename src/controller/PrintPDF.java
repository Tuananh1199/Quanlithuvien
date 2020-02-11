/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

/**
 *
 * @author Admin
 */
public class PrintPDF {
    public static Font createFont(String url, int size) {
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(url, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Font font = new Font(bf, size);
        return font;
    }

    public static PdfPCell getCell(String txt, int alignment) {
        Font fontArial = createFont("C:\\Windows\\Fonts\\Arial.ttf", 12);
        PdfPCell cell = new PdfPCell(new Phrase(txt, fontArial));
//        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
//        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    public static Paragraph getPara(String txt) {
        Font fontArial = createFont("C:\\Windows\\Fonts\\Arial.ttf", 12);
        Paragraph p = new Paragraph(new Phrase(txt, fontArial));
        p.setAlignment(Paragraph.ALIGN_CENTER);

        return p;
    }
    
    public static PdfPCell getParaCell(String txt, int alignment) {
        Font fontArial = createFont("C:\\Windows\\Fonts\\Arial.ttf", 12);
        PdfPCell cell = new PdfPCell(new Phrase(txt, fontArial));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
    
    public static Paragraph getGlueParagraph(String txt1, String txt2){
        Font fontArial = createFont("C:\\Windows\\Fonts\\Arial.ttf", 12);
        Paragraph p = new Paragraph(new Phrase(txt1, fontArial));
        Chunk glue = new Chunk(new VerticalPositionMark());
        p.add(new Chunk(glue));
        p.add(new Phrase(txt2, fontArial));
        
        return p;
    }
}
