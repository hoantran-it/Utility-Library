/**
 * This file Copyright (c) 2016 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This program and the accompanying materials are made
 * available under the terms of the Magnolia Network Agreement
 * which accompanies this distribution, and is available at
 * http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package com.hoantran.utility.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author hoan.tran
 */
public class JsonParser {

    /**
     * Global variable to use entire class.
     */
    private static Gson gson = new Gson();

    /**
     * Convert object to json.
     * 
     * @param object
     * @return
     */
    public static String converFromObjectToJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * Convert object list to json.
     * 
     * @param objectList
     * @return
     */
    public static String converFromObjectListToJson(List<?> objectList) {
        return gson.toJson(objectList);
    }

    /**
     * Convert json to object based on given class.
     * 
     * @param objecClass
     * @param json
     * @return
     */
    public static Object converFromJsonToObject(Class<?> objecClass, String json) {
        return gson.fromJson(json, objecClass);
    }

    /**
     * Convert json to object list based on given class.
     * 
     * @param objecClass
     * @param json
     * @return
     */
    public static <T> List<T> converFromJsonToObjectList(Class<T> objecClass, String json) {
        return gson.fromJson(json, new ListOfJson<T>(objecClass));
    }

    public static class ListOfJson<T> implements ParameterizedType
    {
        private Class<?> wrapped;

        public ListOfJson(Class<T> wrapper)
        {
            this.wrapped = wrapper;
        }

        @Override
        public Type[] getActualTypeArguments()
        {
            return new Type[] { wrapped };
        }

        @Override
        public Type getRawType()
        {
            return List.class;
        }

        @Override
        public Type getOwnerType()
        {
            return null;
        }
    }
}
