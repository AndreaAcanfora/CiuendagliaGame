/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CiuendagliaGame;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class ImgFilter extends FileFilter {

    ImgFilter() {
    }

    @Override
    public boolean accept(File f) {
        return f.getName().toLowerCase().endsWith(".png") || f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "File png,jpg";
    }
}
    

