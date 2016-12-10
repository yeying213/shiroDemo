package org.shrio.viewResolver;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.shrio.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2016/12/8.
 */
@Component
public class UserpdfViewResolver extends AbstractPdfView
{
    /**
     *  自定义pdf视图解析
     *
     * @param map
     * @param document
     * @param pdfWriter
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-Disposition","inline;filename="+new String("用户列表".getBytes(),"iso8859-1"));
        List<User> userList= (List<User>) map.get("user");
        Table table=new Table(3);
        table.setWidth(80);
        table.setBorder(1);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        BaseFont baseFont=BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",false);//使用中文字体
        Font cnFont=new Font(baseFont,10,Font.NORMAL, Color.BLACK);
        table.addCell(buildFontCell("账号",cnFont));
    }

    private Cell buildFontCell(String content, Font font) {
        try {
            Phrase phrase=new Phrase(content,font);
            return new Cell(phrase);
        } catch (BadElementException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
