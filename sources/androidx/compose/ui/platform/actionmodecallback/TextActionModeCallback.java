package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextActionModeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f28352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f28353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function0 f28354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f28355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function0 f28356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0 f28357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Function0 f28358g;

    public TextActionModeCallback(Function0 function0, Rect rect, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06) {
        this.f28352a = function0;
        this.f28353b = rect;
        this.f28354c = function02;
        this.f28355d = function03;
        this.f28356e = function04;
        this.f28357f = function05;
        this.f28358g = function06;
    }

    private final void b(Menu menu, MenuItemOption menuItemOption, Function0 function0) {
        if (function0 != null && menu.findItem(menuItemOption.b()) == null) {
            a(menu, menuItemOption);
        } else {
            if (function0 != null || menu.findItem(menuItemOption.b()) == null) {
                return;
            }
            menu.removeItem(menuItemOption.b());
        }
    }

    public final void a(Menu menu, MenuItemOption menuItemOption) {
        menu.add(0, menuItemOption.b(), menuItemOption.c(), menuItemOption.d()).setShowAsAction(1);
    }

    public final Rect c() {
        return this.f28353b;
    }

    public final boolean d(ActionMode actionMode, MenuItem menuItem) {
        Intrinsics.checkNotNull(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.f28341c.b()) {
            Function0 function0 = this.f28354c;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (itemId == MenuItemOption.f28342d.b()) {
            Function0 function02 = this.f28355d;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (itemId == MenuItemOption.f28343f.b()) {
            Function0 function03 = this.f28356e;
            if (function03 != null) {
                function03.invoke();
            }
        } else if (itemId == MenuItemOption.f28344g.b()) {
            Function0 function04 = this.f28357f;
            if (function04 != null) {
                function04.invoke();
            }
        } else {
            if (itemId != MenuItemOption.f28345h.b()) {
                return false;
            }
            Function0 function05 = this.f28358g;
            if (function05 != null) {
                function05.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final boolean e(ActionMode actionMode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null menu");
        }
        if (actionMode == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode");
        }
        if (this.f28354c != null) {
            a(menu, MenuItemOption.f28341c);
        }
        if (this.f28355d != null) {
            a(menu, MenuItemOption.f28342d);
        }
        if (this.f28356e != null) {
            a(menu, MenuItemOption.f28343f);
        }
        if (this.f28357f != null) {
            a(menu, MenuItemOption.f28344g);
        }
        if (this.f28358g == null) {
            return true;
        }
        a(menu, MenuItemOption.f28345h);
        return true;
    }

    public final void f() {
        Function0 function0 = this.f28352a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean g(ActionMode actionMode, Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        n(menu);
        return true;
    }

    public final void h(Function0 function0) {
        this.f28358g = function0;
    }

    public final void i(Function0 function0) {
        this.f28354c = function0;
    }

    public final void j(Function0 function0) {
        this.f28356e = function0;
    }

    public final void k(Function0 function0) {
        this.f28355d = function0;
    }

    public final void l(Function0 function0) {
        this.f28357f = function0;
    }

    public final void m(Rect rect) {
        this.f28353b = rect;
    }

    public final void n(Menu menu) {
        b(menu, MenuItemOption.f28341c, this.f28354c);
        b(menu, MenuItemOption.f28342d, this.f28355d);
        b(menu, MenuItemOption.f28343f, this.f28356e);
        b(menu, MenuItemOption.f28344g, this.f28357f);
        b(menu, MenuItemOption.f28345h, this.f28358g);
    }

    public /* synthetic */ TextActionModeCallback(Function0 function0, Rect rect, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function0, (i3 & 2) != 0 ? Rect.f25601e.a() : rect, (i3 & 4) != 0 ? null : function02, (i3 & 8) != 0 ? null : function03, (i3 & 16) != 0 ? null : function04, (i3 & 32) != 0 ? null : function05, (i3 & 64) != 0 ? null : function06);
    }
}
