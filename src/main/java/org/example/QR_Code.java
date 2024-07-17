package org.example;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class QR_Code {
    private String str;
    private String path;
    final private static String charset = "UTF-8";
    private int h = 500;

    private int w = 500;

    public QR_Code(String str, String path){
        this.str = str;
        this.path = path;
    }

    public void setStr_Path(String str , String path) {
        this.str = str;
        this.path = path;
    }

    public void setH_W(int h, int w) {
        this.h = h;
        this.w = w;
    }


    public void QR_generator(String data, String path, String charset, int h, int w) throws IOException, WriterException {
        //MultiFormatWriter is a factory class that finds the appropriate Writer subclass for
        // the BarcodeFormat requested and encodes the barcode with the supplied contents
        String j = new String(data.getBytes(charset), charset);

        BitMatrix matrix = new MultiFormatWriter().encode(j,
                BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToPath(matrix, path.substring(
                path.lastIndexOf('.') + 1), new File(path).toPath());
    }
    public void RUNgenerateQR() throws IOException, WriterException {
        QR_generator(str,path,charset,h,w);
        System.out.println("QR generated");
    }

    public String QR_decoder(String Path) throws IOException, NotFoundException {
        FileInputStream red_path = new FileInputStream(Path);

        BufferedImageLuminanceSource f = new BufferedImageLuminanceSource(ImageIO.read(red_path));

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(f));

        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }
    public void RUNdecodeQR(String Path) throws NotFoundException, IOException {

        System.out.println("Data in the QR code is\n" + QR_decoder(Path));
    }
}
