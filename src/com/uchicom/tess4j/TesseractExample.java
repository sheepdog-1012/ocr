// (c) 2017 uchicom
package com.uchicom.tess4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITessAPI.TessPageIteratorLevel;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Word;

/**
 * @author uchicom: Shigeki Uchiyama
 *
 */
public class TesseractExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedImage image = ImageIO.read(new File("sample/desktop_sample3.png"));
			ITesseract instance = new Tesseract(); // JNA Interface Mapping
			// ITesseract instance = new Tesseract1(); // JNA Direct Mapping
			instance.setLanguage("jpn+eng");

			List<Word> wordList = instance.getWords(image, TessPageIteratorLevel.RIL_TEXTLINE);
			for (Word word : wordList) {
				System.out.println(word.getBoundingBox() + ":[" + word.getConfidence() + "]" + word.getText());
			}
//			String result = instance.doOCR(image);
//			System.out.println(result);
//		} catch (TesseractException e) {
//			System.err.println(e.getMessage());
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

}
