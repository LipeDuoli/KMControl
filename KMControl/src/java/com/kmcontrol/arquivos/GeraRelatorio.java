package com.kmcontrol.arquivos;

import com.kmcontrol.dao.AtendimentoDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeraRelatorio {

    private List<DadosRelatorio> dadosRelatorios;

    public void gerarXls(Date dataInicial, Date dataFinal, double valorKm) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        dadosRelatorios = atendimentoDao.listaRelatorio(dataInicial, dataFinal);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        
        XSSFSheet sheet = workbook.createSheet("Prestacao de conta");

        Row header = sheet.createRow(1);
        header.createCell(2).setCellValue("SOLCITACAO DE REQUERIMENTO");

        Row cabecalho = sheet.createRow(7);
        cabecalho.createCell(1).setCellValue("Descrição");
        cabecalho.createCell(2).setCellValue("Reembolso KM");
        cabecalho.createCell(3).setCellValue("Reembolso Outras Despesa");
        cabecalho.createCell(4).setCellValue("Valor Total");
        cabecalho.createCell(5).setCellValue("Dados Bancários");

        int count = 8;
        for (DadosRelatorio dr : dadosRelatorios) {
            Row dataRow = sheet.createRow(count++);
            dataRow.createCell(1).setCellValue(dr.getNome());
            dataRow.createCell(2).setCellValue(dr.getTotalKm());
            dataRow.createCell(3).setCellValue("R$ " + dr.getOutrasDespesas());
            dataRow.createCell(4).setCellValue("R$ " + dr.getTotalKm() * valorKm + dr.getOutrasDespesas());
            dataRow.createCell(5).setCellValue("Banco: " + dr.getNomeBanco() +"\nAgencia: "+ dr.getAgencia() +"\nConta: "+ dr.getConta());
            dataRow.getCell(5).setCellStyle(cs);

        }
        sheet.autoSizeColumn(5);

        try {
            FileOutputStream out = new FileOutputStream(new File("d:\\Requerimento.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Salvo!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
