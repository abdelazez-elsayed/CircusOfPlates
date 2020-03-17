package eg.edu.alexu.csd.oop.game.sample.DynamicLinkage;

import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Linker implements Linkage {

    private static ArrayList<String> Colors = new ArrayList<>();
    private static ArrayList<String> Images =new ArrayList<>();
    private static ArrayList<String> ShapesString = new ArrayList<>();
    private static Map<String,Class<? extends Plates>> ShapesClasses = new HashMap<>();

    @Override
    public void loadImages(String jarPath){
        File file = new File(jarPath);
        String Path;
        try {
            URLClassLoader child = new URLClassLoader(
                    new URL[] {file.toURI().toURL()},
                    this.getClass().getClassLoader()
            );
            String className = new String();
            ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));

            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {

                    className = entry.getName().replace('/', '.');
                    className = className.substring(0, className.length() - ".class".length());
                    Path = className.substring("eg.edu.alexu.csd.oop.game.sample.GameObjects.".length());
                    //  String
                    System.out.println(className);
                    Class classtoLoad;
                    if(className.startsWith("eg.edu.alexu.csd.oop.game.sample.GameObjects.")) {
                        classtoLoad = Class.forName(className,true,child);
                    } else {
                        classtoLoad = Class.forName( className, true, child);
                    }
                    Constructor constructor=classtoLoad.getDeclaredConstructor(int.class,int.class,String.class);
                    System.out.println(className);
                    Plates plate = (Plates)constructor.newInstance(0,0,"");
                    ShapesClasses.put(className,classtoLoad);
                    if(!Images.contains(plate.getType()))
                        Images.add(plate.getType());
                    if(!Colors.contains(plate.getColor()));
                    Colors.add(plate.getColor());
                    ShapesString.add(Path);
                }else if(!entry.isDirectory() && entry.getName().endsWith(".png")){
                    ZipFile zipy = new ZipFile(jarPath);
                    String ClassName = entry.getName().substring(0,entry.getName().length()-".png".length());
                    System.out.println(ClassName);
                    Path = entry.getName().substring("eg.edu.alexu.csd.oop.game.sample.GameObjects.".length());
                    for (Enumeration e = zipy.entries(); e.hasMoreElements();){
                        ZipEntry entryy = (ZipEntry) e.nextElement();
                        if (!entryy.isDirectory()&&entry.getName().equalsIgnoreCase(entryy.getName())){
                            ClassName=ClassName.replace('/','.');
                            Constructor constructor=ShapesClasses.get(ClassName).getDeclaredConstructor(int.class,int.class,String.class);
                            Plates plate = (Plates)constructor.newInstance(0,0,"/"+Path+".png");
                            InputStream iss = zipy.getInputStream(entryy);
                            BufferedImage image = ImageIO.read(iss);
                            plate.setBuf(image);
                        }
                    }
                }
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, Class<? extends Plates>> getClasses() {
        return ShapesClasses;
    }

    @Override
    public ArrayList<String> getColors() {
        return Colors;
    }

    @Override
    public ArrayList<String> getShapes() {
        return Images;
    }

    @Override
    public ArrayList<String> getShapesString() {
        return ShapesString;
    }
}
