package util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    public static List<Class<?>> find(String packageName, ClassLoader classLoader) {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');

        try {
            ClassLoader cl = classLoader != null ? classLoader : Thread.currentThread().getContextClassLoader();
            URL packageURL = cl.getResource(path);
            File packageDir = new File(packageURL.toURI());

            if (packageDir.isDirectory()) {
                String[] files = packageDir.list();
                for (String file : files) {
                    if (file.endsWith(".class")) {
                        String className = packageName + "." + file.substring(0, file.length() - 6);
                        Class<?> myClass = cl.loadClass(className);
                        classes.add(myClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }
}