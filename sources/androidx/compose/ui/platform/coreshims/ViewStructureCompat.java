package androidx.compose.ui.platform.coreshims;

import android.os.Bundle;
import android.view.ViewStructure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewStructureCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f28364a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api23Impl {
        static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }

        static void b(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        static void c(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void d(ViewStructure viewStructure, int i3, int i4, int i5, int i6, int i7, int i8) {
            viewStructure.setDimens(i3, i4, i5, i6, i7, i8);
        }

        static void e(ViewStructure viewStructure, int i3, String str, String str2, String str3) {
            viewStructure.setId(i3, str, str2, str3);
        }

        static void f(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        static void g(ViewStructure viewStructure, float f3, int i3, int i4, int i5) {
            viewStructure.setTextStyle(f3, i3, i4, i5);
        }
    }

    private ViewStructureCompat(ViewStructure viewStructure) {
        this.f28364a = viewStructure;
    }

    public static ViewStructureCompat i(ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public Bundle a() {
        return Api23Impl.a((ViewStructure) this.f28364a);
    }

    public void b(String str) {
        Api23Impl.b((ViewStructure) this.f28364a, str);
    }

    public void c(CharSequence charSequence) {
        Api23Impl.c((ViewStructure) this.f28364a, charSequence);
    }

    public void d(int i3, int i4, int i5, int i6, int i7, int i8) {
        Api23Impl.d((ViewStructure) this.f28364a, i3, i4, i5, i6, i7, i8);
    }

    public void e(int i3, String str, String str2, String str3) {
        Api23Impl.e((ViewStructure) this.f28364a, i3, str, str2, str3);
    }

    public void f(CharSequence charSequence) {
        Api23Impl.f((ViewStructure) this.f28364a, charSequence);
    }

    public void g(float f3, int i3, int i4, int i5) {
        Api23Impl.g((ViewStructure) this.f28364a, f3, i3, i4, i5);
    }

    public ViewStructure h() {
        return (ViewStructure) this.f28364a;
    }
}
