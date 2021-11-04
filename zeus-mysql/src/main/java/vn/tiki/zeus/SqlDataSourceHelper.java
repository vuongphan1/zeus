package vn.tiki.zeus;

import io.gridgo.utils.ThreadUtils;
import lombok.AllArgsConstructor;
import org.vibur.dbcp.ViburDBCPDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
class SqlDataSourceHelper {

    static DataSource createFromProperties(final Properties config) {
        final var dataSource = new ViburDBCPDataSource(config);
        dataSource.start();
        ThreadUtils.registerShutdownTask(dataSource::close);
        return dataSource;
    }

    static DataSource createFromProperties(final File file) {
        try (InputStream inputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return createFromProperties(properties);
        } catch (Exception e) {
            throw new RuntimeException("Error while loading config properties file at: " + file.getAbsolutePath(), e);
        }
    }

    static DataSource createFromProperties(final String configPropertiesFile) {
        return createFromProperties(new File(configPropertiesFile));
    }
}
