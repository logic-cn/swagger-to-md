package com.logic;

import java.nio.file.Paths;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

/**
 * description
 *
 * @author PC 2023/03/31 18:25
 */
public class Application {

    /**
     * Swagger 地址
     */
    public static final String SWAGGER_URL = "http://localhost:80/demo/api-docs";
    /**
     * 本地文件地址
     */
    public static final String LOCAL_PATH = "src/main/resources/demo.json";

    /**
     * 输出路径
     */
    public static final String OUT_PATH = "src/main/resources/docs/demo";

    public static void main(String[] args) {
        //    设置生成格式、设置语言中文还是其他语言
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

//        Swagger2MarkupConverter.from(new URL("http://localhost:80/demo/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get(OUT_PATH));

        // 从本地文件中生成
        Swagger2MarkupConverter.from(Paths.get(LOCAL_PATH))
                .withConfig(config)
                .build()
                .toFile(Paths.get(OUT_PATH));

    }
}
