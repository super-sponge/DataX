package com.alibaba.datax.plugin.reader.oraclereader;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MetaUtilsTest {
    @Test
    public void executeCommandLine() throws Exception {
        String[] args = {"",
                "-j", "jdbc:oracle:thin:@10.0.8.156:1521:orcl",
                "-u", "scott",
                "-p", "tiger",
                "-t", "EMP",
                "-f", "./emp.txt"
        };
        MetaUtils.ExecuteCommandLine(args);
    }

    @Test
    public void getOracleTableMetaInfo() throws Exception {
        List<MetaUtils.MetaInfo> metaInfos =   MetaUtils.getOracleTableMetaInfo("jdbc:oracle:thin:@10.0.8.156:1521:orcl",
                "scott",
                "tiger",
                "EMP");
        for (MetaUtils.MetaInfo metaInfo : metaInfos) {
            System.out.println(metaInfo);
        }
    }

    @org.junit.Test
    public void transOracleColumnToHiveColumn() throws Exception {
        assertEquals(MetaUtils.transOracleColumnToHiveColumn("LONG"), "STRING");
        assertEquals(MetaUtils.transOracleColumnToHiveColumn("ERROR TYPE"), "STRING");
    }

}