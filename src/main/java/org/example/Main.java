package org.example;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, WriterException, NotFoundException {
        String s = ("this is the new program based on OOPs");
        String p = ("D:\\QR_Project\\imageKK.jpg");

        String e = ("this is the 2nd string created by OOPs");
        String r = ("D:\\QR_Project\\image2.jpg");

        QR_Code k = new QR_Code(s, p);
        QR_Code d = new QR_Code(e, r);
        k.setH_W(100,100);
        k.setStr_Path("changed","D:\\QR_Project\\imageSizeChanged.jpg");
        k.RUNgenerateQR();

        d.RUNgenerateQR();
        k.RUNdecodeQR("D:\\QR_Project\\imageKK.jpg");
        //System.out.println("Hello world!");
    }
}