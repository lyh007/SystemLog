package com.lyh.systemlog.freemarker;

import freemarker.cache.TemplateLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-24上午11:56
 * @Email liuyuhui007@gmail.com
 * 重写Freemarker的模板加载器支持字符串模板
 */
public class StringTemplateLoader implements TemplateLoader {
    private static final String DEFAULT_TEMPLATE_KEY = "_default_template_key";
    private Map templates = new HashMap();

    public StringTemplateLoader(String defaultTemplate) {
        if (defaultTemplate != null && !defaultTemplate.equals("")) {
            templates.put(DEFAULT_TEMPLATE_KEY, defaultTemplate);
        }
    }

    public Object findTemplateSource(String name) throws IOException {
        if (name == null || name.equals("")) {
            name = DEFAULT_TEMPLATE_KEY;
        }
        return templates.get(name);
    }

    public long getLastModified(Object o) {
        return 0;
    }

    public Reader getReader(Object templateSource, String s) throws IOException {
        return new StringReader((String) templateSource);
    }

    public void closeTemplateSource(Object o) throws IOException {
    }

    public void AddTemplate(String name, String template) {
        if (name == null || template == null || name.equals("")
                || template.equals("")) {
            return;
        }
        if (!templates.containsKey(name)) {
            templates.put(name, template);
        }
    }
}
