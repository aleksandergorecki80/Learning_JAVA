public interface Chef {

    String favouriteFood = "Hamburger";
    default void cook(String food){
        System.out.println("I am now cooking " + food);
    }

    default String clean(){
        return "I am cleaning up.";
    }

    String yellAtPeople();

    default String getFavouriteFood(){
        return favouriteFood;
    }
}
