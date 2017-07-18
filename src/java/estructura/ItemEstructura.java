/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.List;

/**
 *
 * @author TAWSBC
 */
public class ItemEstructura {

    private int id;
    private String text;
    private String href;
    private String tags;
    private String icon;
    private boolean selected;
    private String backColor;
    private List<ItemEstructura> children;
    private int contador;

    public ItemEstructura() {
    }

    public ItemEstructura(int id, String text, String href, String tags, String icon, boolean selected, String backColor, List<ItemEstructura> nodes, int contador) {
        this.id = id;
        this.text = text;
        this.href = href;
        this.tags = tags;
        this.icon = icon;
        this.selected = selected;
        this.backColor = backColor;
        this.children = nodes;
        this.contador = contador;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return the tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the backColor
     */
    public String getBackColor() {
        return backColor;
    }

    /**
     * @param backColor the backColor to set
     */
    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    /**
     * @return the children
     */
    public List<ItemEstructura> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<ItemEstructura> children) {
        this.children = children;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }
}
