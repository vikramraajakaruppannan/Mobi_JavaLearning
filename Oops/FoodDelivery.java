import java.util.*;

class Customer{
    private int id;
    private String name;
    private String location;

    Customer(int id,String name, String location){
        this.id =id;
        this.name = name;
        this.location=location;
    }

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setLocation(String location) {this.location = location;}

    public int getId(){return id;}
    public String getName(){return name;}
    public String getLocation(){return location;}
}

class Restaurant{
    private int id;
    private String name;
    private float rating;
    
    Restaurant(int id,String name, float rating){
        this.id = id;
        this.name =name;
        this.rating = rating;
    }

    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setRating(float rating){
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public float getRating(){return rating;}
}

class Order{
    private int orderID;
    private String foodItem;
    private float price;
    private float distance;
    private Customer customer;
    private Restaurant restaurant;

    public Order(int orderID, String foodItem, float price, float distance,Customer customer, Restaurant restaurant) {
    this.orderID = orderID;
    this.foodItem = foodItem;
    this.price = price;
    this.distance = distance;
    this.customer = customer;
    this.restaurant = restaurant;
}

    public void setOrderId(int orderID){this.orderID =orderID;}
    public void setFoodItem(String foodItem){this.foodItem = foodItem;}
    public void setPrice(float price){this.price=price;}
    public void setDistance(float distance){this.distance=distance;}
    public void setCustomer(Customer customer){this.customer = customer;}
    public void setRestaurant(Restaurant restaurant){this.restaurant=restaurant;}

    public int getOrderId(){return orderID;}
    public String getFoodItem(){return foodItem;}
    public float getPrice(){return price;}
    public float getDistance(){return distance;}
    public Customer getCustomer(){return customer;}
    public Restaurant getRestaurant(){return restaurant;}
}

class FoodDelivery{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Order[] list = new Order[n];

        for(int i=0;i<n;i++){
            int oid = sc.nextInt();
            String fooditem = sc.next();
            float price = sc.nextFloat();
            float distance = sc.nextFloat();

            int cid = sc.nextInt();
            String cname = sc.next();
            String clocation = sc.next();

            int rid = sc.nextInt();
            String rname = sc.next();
            float rating = sc.nextFloat();

            Customer c = new Customer(cid,cname,clocation);
            Restaurant r = new Restaurant(rid,rname,rating);

            list[i]= new Order(oid,fooditem,price,distance,c,r);
        }
        float maxidistance = sc.nextFloat();

        Order[] filtered = new Order[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(list[i].getDistance() <= maxidistance)
                filtered[count++]=list[i];
        }

        // Arrays.sort(filtered, 0, count, (a, b) -> {
        //     int ratingCompare = Float.compare(
        //         b.getRestaurant().getRating(),
        //         a.getRestaurant().getRating()
        //     );

        //     if (ratingCompare != 0) return ratingCompare;

        //     return Float.compare(
        //         a.getPrice(),
        //         b.getPrice()
        //     );
        // });

        for(int i=0;i<count-1;i++){
            for(int j=0;j<count-i-1;j++){
                float ratingA = filtered[j].getRestaurant().getRating();
                float ratingB = filtered[j+1].getRestaurant().getRating();

                boolean swap = false;

                if(ratingA< ratingB) swap = true;
                // else if(Math.abs(ratingA - ratingB) < 0.0001) this is to handle the float comparison part
                else if(ratingA==ratingB){
                    float priceA = filtered[j].getPrice();
                    float priceB = filtered[j+1].getPrice();

                    if(priceA>priceB) swap = true;
                }

                if(swap){
                Order temp = filtered[j];
                filtered[j]=filtered[j+1];
                filtered[j+1]=temp;
            }
            }
            
        }

        if(count==0) System.out.println("Orders not Found....");
        else{
            for(int i=0;i<count;i++){
                System.out.println(filtered[i].getOrderId()+" "+filtered[i].getCustomer().getName()+" "+
                filtered[i].getRestaurant().getName()+" "+filtered[i].getPrice()+" "+
                filtered[i].getRestaurant().getRating());
            }
        }

    }
}