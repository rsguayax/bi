/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author TAWSBC
 */
public class FileUploadMD {

    private MultipartFile imagen;
    private List<MultipartFile> adjuntos;
    
    private List<String> youtube;
    private List<String> twitter;
    private List<String> facebook;
    /**
     * @return the imagen
     */
    public MultipartFile getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the adjuntos
     */
    public List<MultipartFile> getAdjuntos() {
        return adjuntos;
    }

    /**
     * @param adjuntos the adjuntos to set
     */
    public void setAdjuntos(List<MultipartFile> adjuntos) {
        this.adjuntos = adjuntos;
    }
    
    /**
     * @return the youtube
     */
    public List<String> getYoutube() {
        return youtube;
    }

    /**
     * @param youtube the youtube to set
     */
    public void setYoutube(List<String> youtube) {
        this.youtube = youtube;
    }

    /**
     * @return the twitter
     */
    public List<String> getTwitter() {
        return twitter;
    }

    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(List<String> twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the facebook
     */
    public List<String> getFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(List<String> facebook) {
        this.facebook = facebook;
    }
}