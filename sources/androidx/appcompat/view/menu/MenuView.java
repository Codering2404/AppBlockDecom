package androidx.appcompat.view.menu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface MenuView {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ItemView {
        void c(MenuItemImpl menuItemImpl, int i3);

        boolean d();

        MenuItemImpl getItemData();
    }

    void a(MenuBuilder menuBuilder);
}
