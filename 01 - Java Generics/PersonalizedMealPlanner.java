import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanName();
    List<String> getMeals();
}

class VegetarianMeal implements MealPlan {
    public String getPlanName() {
        return "Vegetarian";
    }

    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Grilled Veggie Wrap");
        meals.add("Lentil Soup");
        meals.add("Tofu Stir Fry");
        return meals;
    }
}

class VeganMeal implements MealPlan {
    public String getPlanName() {
        return "Vegan";
    }

    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Vegan Burrito Bowl");
        meals.add("Chickpea Salad");
        meals.add("Vegan Pasta");
        return meals;
    }
}

class KetoMeal implements MealPlan {
    public String getPlanName() {
        return "Keto";
    }

    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Keto Chicken Bowl");
        meals.add("Zucchini Noodles");
        meals.add("Avocado Egg Salad");
        return meals;
    }
}

class HighProteinMeal implements MealPlan {
    public String getPlanName() {
        return "High-Protein";
    }

    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Grilled Chicken");
        meals.add("Quinoa Salad");
        meals.add("Protein Smoothie");
        return meals;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayPlan() {
        System.out.println("Meal Plan: " + mealPlan.getPlanName());
        for (String meal : mealPlan.getMeals()) {
            System.out.println("- " + meal);
        }
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generatePlan(T plan) {
        return new Meal<>(plan);
    }
}

public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarian = MealPlanGenerator.generatePlan(new VegetarianMeal());
        Meal<VeganMeal> vegan = MealPlanGenerator.generatePlan(new VeganMeal());
        Meal<KetoMeal> keto = MealPlanGenerator.generatePlan(new KetoMeal());
        Meal<HighProteinMeal> highProtein = MealPlanGenerator.generatePlan(new HighProteinMeal());

        vegetarian.displayPlan();
        System.out.println();
        vegan.displayPlan();
        System.out.println();
        keto.displayPlan();
        System.out.println();
        highProtein.displayPlan();
    }
}
