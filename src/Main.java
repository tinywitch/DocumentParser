import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Main
{
	public static void main(String[] args)
	{
		String filepath = "test.pdf";
		File file = new File(filepath);
		String text = PDFReader.getContent(file);
		System.out.println(text);
		char[] textCharArray = text.toCharArray();
		
		int wordCount = 0;
		int sentenseCount = 0;
		for (char c : textCharArray)
		{
			if (c == ' ')
			{
				wordCount++;
			}
			if (c == '.')
			{
				sentenseCount++;
			}
		}
		System.out.println("So tu: " + wordCount);
		System.out.println("So cau: "+ sentenseCount);
	}
}
