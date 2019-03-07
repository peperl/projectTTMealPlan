package mx.ipn.www.finalproject.model;

/*
 * For Table categoriaalimento
 */
public class Categoriaalimento implements java.io.Serializable, Cloneable {
    private CategoriaalimentoKey _key = new CategoriaalimentoKey();

    /* category_id, PK */
    protected int categoryId;

    /* NombreCategoria */
    protected String nombrecategoria;

    /* Return the key object. */
    public CategoriaalimentoKey getKeyObject() {
        return _key;
    }

    /* category_id, PK */
    public int getCategoryId() {
        return categoryId;
    }

    /* category_id, PK */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        _key.setCategoryId(categoryId);
    }

    /* NombreCategoria */
    public String getNombrecategoria() {
        return nombrecategoria;
    }

    /* NombreCategoria */
    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Categoriaalimento))
            return false;

        Categoriaalimento bean = (Categoriaalimento) obj;

        if (this.categoryId != bean.categoryId)
            return false;

        if (this.nombrecategoria == null) {
            if (bean.nombrecategoria != null)
                return false;
        }
        else if (!this.nombrecategoria.equals(bean.nombrecategoria)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Categoriaalimento bean = new Categoriaalimento();
        bean.categoryId = this.categoryId;
        bean.nombrecategoria = this.nombrecategoria;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("categoryId").append(" = ").append(categoryId).append("]").append(sep);
        sb.append("[").append("nombrecategoria").append(" = ").append(nombrecategoria).append("]").append(sep);
        return sb.toString();
    }
}