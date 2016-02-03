package com.pblog.core.markdown;

import org.parboiled.support.Var;

import java.util.HashMap;
import java.util.Map;

public class ParamVar extends Var<Map<String, String>> {
    public ParamVar() {
        super(new HashMap<String, String>());
    }

    public boolean put(String key, String value) {
        get().put(key, value);
        return true;
    }
}
