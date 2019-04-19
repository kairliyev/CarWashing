package kz.kairliyev.carwashing.models;

public class ShopData {
    private String shop_logo;
    private String shop_name;
    private String shop_address;
    private String shop_type;
    private String shop_image;
    private String shop_admin_name;
    private String shop_admin_phone_number;
    private String shop_working_time;
    private String latlng;

    public ShopData(String shop_logo, String shop_name, String latlng, String shop_address, String shop_type, String shop_image, String shop_admin_name, String shop_admin_phone_number, String shop_working_time) {
        this.shop_logo = shop_logo;
        this.shop_name = shop_name;
        this.latlng = latlng;
        this.shop_address = shop_address;
        this.shop_type = shop_type;
        this.shop_image = shop_image;
        this.shop_admin_name = shop_admin_name;
        this.shop_admin_phone_number = shop_admin_phone_number;
        this.shop_working_time = shop_working_time;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getShop_logo() {
        return shop_logo;
    }

    public void setShop_logo(String shop_logo) {
        this.shop_logo = shop_logo;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getShop_image() {
        return shop_image;
    }

    public void setShop_image(String shop_image) {
        this.shop_image = shop_image;
    }

    public String getShop_admin_name() {
        return shop_admin_name;
    }

    public void setShop_admin_name(String shop_admin_name) {
        this.shop_admin_name = shop_admin_name;
    }

    public String getShop_admin_phone_number() {
        return shop_admin_phone_number;
    }

    public void setShop_admin_phone_number(String shop_admin_phone_number) {
        this.shop_admin_phone_number = shop_admin_phone_number;
    }

    public String getShop_working_time() {
        return shop_working_time;
    }

    public void setShop_working_time(String shop_working_time) {
        this.shop_working_time = shop_working_time;
    }




}
