package net.rebi.estore.classes;

import java.io.Serializable;

public class items_class implements Serializable {
    private String  id;
    private String  title;
    private Float   price;
    private boolean delivery;
    private String  description;
    private String  image;
    private int     image2;
    private int     sales;
    private String  section_id;
    private String  company_name;

    public items_class (
            String id , String title , Float price , boolean delivery , String description ,
            String image , int sales , String section_id , String company_name , int image2
    ) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.delivery = delivery;
        this.description = description;
        this.image = image;
        this.sales = sales;
        this.section_id = section_id;
        this.company_name = company_name;
        this.image2 = image2;
    }

    public int getImage2 ( ) {
        return image2;
    }

    public String getId ( ) {
        return id;
    }

    public String getTitle ( ) {
        return title;
    }

    public Float getPrice ( ) {
        return price;
    }

    public boolean isDelivery ( ) {
        return delivery;
    }

    public String getDescription ( ) {
        return description;
    }

    public String getImage ( ) {
        return image;
    }

    public int getSales ( ) {
        return sales;
    }

    public String getSection_id ( ) {
        return section_id;
    }

    public String getCompany_name ( ) {
        return company_name;
    }
}
