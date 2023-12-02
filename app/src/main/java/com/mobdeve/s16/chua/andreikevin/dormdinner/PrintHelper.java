package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.os.Environment;
import android.os.FileUriExposedException;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class PrintHelper {
    public Boolean write(String fname, String fcontent) throws FileUriExposedException, FileNotFoundException {
        // Creating a PdfWriter
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, fname + ".pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        document.close();
        return true;

    }
}
