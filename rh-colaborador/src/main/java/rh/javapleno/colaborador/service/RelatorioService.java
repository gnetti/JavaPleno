package rh.javapleno.colaborador.service;


import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    @Value("classpath:reports/relvalortotaldiastrabporcolab.jrxml")
    private Resource relvalortotaldiastrabporcolab;

    @Autowired
    private DataSource dataSource;

    public byte[] gerarRelatorio() {
        try (
                Connection connection = dataSource.getConnection();
        ) {
            JasperReport compileReport = JasperCompileManager.compileReport(relvalortotaldiastrabporcolab.getInputStream());
            Map<String, Object> parametros = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(compileReport, parametros, connection);
            return JasperExportManager.exportReportToPdf(print);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
