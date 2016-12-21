import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class DocReader
{
	public static String getContent(File file)
	{
		FileInputStream fis;
		String text = "";

		if (file.getPath().substring(file.getPath().length() - 1).equals("x"))
		{ 
			try
			{
				fis = new FileInputStream(file);
				XWPFDocument doc = new XWPFDocument(fis);
				XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
				 text = extractor.getText();
			}
			catch (IOException e)
			{

				e.printStackTrace();
			}
		}
		else
		{ // is not a docx
			try
			{
				fis = new FileInputStream(file);
				HWPFDocument doc = new HWPFDocument(fis);
				WordExtractor extractor = new WordExtractor(doc);
				text = extractor.getText();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return text;
	}
}
