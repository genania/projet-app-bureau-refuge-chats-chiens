package Refuge.Swinger;

import java.util.Stack;

public class NavigationManager {
    // Pile d'historique pour stocker les actions de navigation
    private static Stack<Runnable> pageHistory = new Stack<>();

    // Navigue vers une nouvelle page
    public static void navigateTo(Window window, Runnable openPageAction) {
        // Ajoute l'action actuelle à l'historique
        pageHistory.push(() -> openPageAction.run());
        openPageAction.run(); // Charge la nouvelle page
    }

    // Retourne à la page précédente
    public static void goBack(Window window) {
        if (!pageHistory.isEmpty()) {
            pageHistory.pop(); // Supprime la page actuelle
            if (!pageHistory.isEmpty()) {
                pageHistory.peek().run(); // Recharge la page précédente
            } else {
                System.out.println("Aucune page précédente dans l'historique !");
                window.clear(); // Vide la fenêtre si l'historique est vide
            }
        } else {
            System.out.println("Historique vide. Impossible de revenir en arrière.");
        }
    }

    // Vérifie si l'historique est vide
    public static boolean hasPreviousPage() {
        return !pageHistory.isEmpty();
    }

    // Vide complètement l'historique
    public static void clearHistory() {
        pageHistory.clear();
    }
}
