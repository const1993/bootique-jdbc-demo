package io.bootique.jdbc.demo;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.bootique.cli.Cli;
import io.bootique.command.CommandOutcome;
import io.bootique.command.CommandWithMetadata;
import io.bootique.jdbc.DataSourceFactory;
import io.bootique.meta.application.CommandMetadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCommand extends CommandWithMetadata {
    private Provider<DataSourceFactory> dataSource;

    @Inject
    public SelectCommand(Provider<DataSourceFactory> dataSource) {
        super(CommandMetadata.builder(SelectCommand.class).description("Demo command to select data.").build());
        this.dataSource = dataSource;
    }

    @Override
    public CommandOutcome run(Cli cli) {
        try (Connection connection = dataSource.get().forName("DerbyDatabase").getConnection()) {

            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery("SELECT * FROM TEST WHERE ID=1");
                while (rs.next()) {
                    System.out.println(String.format("The text in selected row is: %s", rs.getString("name")));
                }
            }

        } catch (SQLException e) {
            return CommandOutcome.failed(1, e);
        }

        return CommandOutcome.succeeded();
    }
}
