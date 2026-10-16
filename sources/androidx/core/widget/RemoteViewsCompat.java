package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RemoteViewsCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RemoteViewsCompat f34689a = new RemoteViewsCompat();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api23Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api23Impl f34690a = new Api23Impl();

        private Api23Impl() {
        }

        @JvmStatic
        public static final void a(RemoteViews rv, int i3, String method, Icon icon) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setIcon(i3, method, icon);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api31Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api31Impl f34691a = new Api31Impl();

        private Api31Impl() {
        }

        @JvmStatic
        public static final void a(RemoteViews rv, int i3, String method, BlendMode blendMode) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setBlendMode(i3, method, blendMode);
        }

        @JvmStatic
        public static final void b(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setCharSequence(i3, method, i4);
        }

        @JvmStatic
        public static final void c(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setCharSequenceAttr(i3, method, i4);
        }

        @JvmStatic
        public static final void d(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColor(i3, method, i4);
        }

        @JvmStatic
        public static final void e(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColorAttr(i3, method, i4);
        }

        @JvmStatic
        public static final void f(RemoteViews rv, int i3, String method, int i4, int i5) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColorInt(i3, method, i4, i5);
        }

        @JvmStatic
        public static final void g(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColorStateList(i3, method, i4);
        }

        @JvmStatic
        public static final void h(RemoteViews rv, int i3, String method, ColorStateList colorStateList) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColorStateList(i3, method, colorStateList);
        }

        @JvmStatic
        public static final void i(RemoteViews rv, int i3, String method, ColorStateList colorStateList, ColorStateList colorStateList2) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColorStateList(i3, method, colorStateList, colorStateList2);
        }

        @JvmStatic
        public static final void j(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setColorStateListAttr(i3, method, i4);
        }

        @JvmStatic
        public static final void k(RemoteViews rv, int i3, String method, float f3, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setFloatDimen(i3, method, f3, i4);
        }

        @JvmStatic
        public static final void l(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setFloatDimen(i3, method, i4);
        }

        @JvmStatic
        public static final void m(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setFloatDimenAttr(i3, method, i4);
        }

        @JvmStatic
        public static final void n(RemoteViews rv, int i3, String method, Icon icon, Icon icon2) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setIcon(i3, method, icon, icon2);
        }

        @JvmStatic
        public static final void o(RemoteViews rv, int i3, String method, float f3, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setIntDimen(i3, method, f3, i4);
        }

        @JvmStatic
        public static final void p(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setIntDimen(i3, method, i4);
        }

        @JvmStatic
        public static final void q(RemoteViews rv, int i3, String method, int i4) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(method, "method");
            rv.setIntDimenAttr(i3, method, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CollectionItemsApi31Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CollectionItemsApi31Impl f34692a = new CollectionItemsApi31Impl();

        private CollectionItemsApi31Impl() {
        }

        private final RemoteViews.RemoteCollectionItems b(RemoteCollectionItems remoteCollectionItems) {
            RemoteViews.RemoteCollectionItems.Builder viewTypeCount = new RemoteViews.RemoteCollectionItems.Builder().setHasStableIds(remoteCollectionItems.e()).setViewTypeCount(remoteCollectionItems.d());
            int iA = remoteCollectionItems.a();
            for (int i3 = 0; i3 < iA; i3++) {
                viewTypeCount.addItem(remoteCollectionItems.b(i3), remoteCollectionItems.c(i3));
            }
            RemoteViews.RemoteCollectionItems remoteCollectionItemsBuild = viewTypeCount.build();
            Intrinsics.checkNotNullExpressionValue(remoteCollectionItemsBuild, "Builder()\n              …\n                .build()");
            return remoteCollectionItemsBuild;
        }

        public final void a(RemoteViews remoteViews, int i3, RemoteCollectionItems items) {
            Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
            Intrinsics.checkNotNullParameter(items, "items");
            remoteViews.setRemoteAdapter(i3, b(items));
        }
    }

    private RemoteViewsCompat() {
    }

    public static final void A(RemoteViews remoteViews, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.f(remoteViews, i3, "setTextColor", i4, i5);
    }

    public static final void B(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setTextColor", i4);
    }

    public static final void C(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setWidth", i4);
    }

    public static final void D(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setBackgroundColor", i4);
    }

    public static final void E(RemoteViews remoteViews, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.f(remoteViews, i3, "setBackgroundColor", i4, i5);
    }

    public static final void F(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.d(remoteViews, i3, "setBackgroundColor", i4);
        } else {
            remoteViews.setInt(i3, "setBackgroundResource", i4);
        }
    }

    public static final void G(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setBackgroundResource", i4);
    }

    public static final void H(RemoteViews remoteViews, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        f34689a.a(31, "setClipToOutline");
        remoteViews.setBoolean(i3, "setClipToOutline", z2);
    }

    public static final void I(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        f34689a.a(16, "setInflatedId");
        remoteViews.setInt(i3, "setInflatedId", i4);
    }

    public static final void J(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        f34689a.a(16, "setLayoutResource");
        remoteViews.setInt(i3, "setLayoutResource", i4);
    }

    private final void a(int i3, String str) {
        if (Build.VERSION.SDK_INT >= i3) {
            return;
        }
        throw new IllegalArgumentException((str + " is only available on SDK " + i3 + " and higher").toString());
    }

    public static final void b(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setButtonTintList", i4);
    }

    public static final void c(RemoteViews remoteViews, int i3, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.i(remoteViews, i3, "setButtonTintList", colorStateList, colorStateList2);
    }

    public static final void d(RemoteViews remoteViews, int i3, float f3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.o(remoteViews, i3, "setColumnWidth", f3, i4);
    }

    public static final void e(RemoteViews remoteViews, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setBoolean(i3, "setAdjustViewBounds", z2);
    }

    public static final void f(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setColorFilter", i4);
    }

    public static final void g(RemoteViews remoteViews, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.f(remoteViews, i3, "setColorFilter", i4, i5);
    }

    public static final void h(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.d(remoteViews, i3, "setColorFilter", i4);
    }

    public static final void i(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setImageAlpha", i4);
    }

    public static final void j(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setGravity", i4);
    }

    public static final void k(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setIndeterminateTintList", i4);
    }

    public static final void l(RemoteViews remoteViews, int i3, ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.h(remoteViews, i3, "setIndeterminateTintList", colorStateList);
    }

    public static final void m(RemoteViews remoteViews, int i3, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.i(remoteViews, i3, "setIndeterminateTintList", colorStateList, colorStateList2);
    }

    public static final void n(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setProgressBackgroundTintList", i4);
    }

    public static final void o(RemoteViews remoteViews, int i3, ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.h(remoteViews, i3, "setProgressBackgroundTintList", colorStateList);
    }

    public static final void p(RemoteViews remoteViews, int i3, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.i(remoteViews, i3, "setProgressBackgroundTintList", colorStateList, colorStateList2);
    }

    public static final void q(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setProgressTintList", i4);
    }

    public static final void r(RemoteViews remoteViews, int i3, ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.h(remoteViews, i3, "setProgressTintList", colorStateList);
    }

    public static final void s(RemoteViews remoteViews, int i3, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.i(remoteViews, i3, "setProgressTintList", colorStateList, colorStateList2);
    }

    public static final void t(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setThumbTintList", i4);
    }

    public static final void u(RemoteViews remoteViews, int i3, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.i(remoteViews, i3, "setThumbTintList", colorStateList, colorStateList2);
    }

    public static final void v(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.g(remoteViews, i3, "setTrackTintList", i4);
    }

    public static final void w(RemoteViews remoteViews, int i3, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Api31Impl.i(remoteViews, i3, "setTrackTintList", colorStateList, colorStateList2);
    }

    public static final void x(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        f34689a.a(31, "setGravity");
        remoteViews.setInt(i3, "setGravity", i4);
    }

    public static final void y(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setHeight", i4);
    }

    public static final void z(RemoteViews remoteViews, int i3, int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        remoteViews.setInt(i3, "setMaxLines", i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RemoteCollectionItems {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Companion f34693e = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f34694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RemoteViews[] f34695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f34696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f34697d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public RemoteCollectionItems(long[] ids, RemoteViews[] views, boolean z2, int i3) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            Intrinsics.checkNotNullParameter(views, "views");
            this.f34694a = ids;
            this.f34695b = views;
            this.f34696c = z2;
            this.f34697d = i3;
            if (ids.length != views.length) {
                throw new IllegalArgumentException("RemoteCollectionItems has different number of ids and views");
            }
            if (i3 < 1) {
                throw new IllegalArgumentException("View type count must be >= 1");
            }
            ArrayList arrayList = new ArrayList(views.length);
            for (RemoteViews remoteViews : views) {
                arrayList.add(Integer.valueOf(remoteViews.getLayoutId()));
            }
            int size = CollectionsKt.distinct(arrayList).size();
            if (size <= i3) {
                return;
            }
            throw new IllegalArgumentException(("View type count is set to " + i3 + ", but the collection contains " + size + " different layout ids").toString());
        }

        public final int a() {
            return this.f34694a.length;
        }

        public final long b(int i3) {
            return this.f34694a[i3];
        }

        public final RemoteViews c(int i3) {
            return this.f34695b[i3];
        }

        public final int d() {
            return this.f34697d;
        }

        public final boolean e() {
            return this.f34696c;
        }

        public final void f(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.f34694a.length);
            dest.writeLongArray(this.f34694a);
            dest.writeTypedArray(this.f34695b, i3);
            dest.writeInt(this.f34696c ? 1 : 0);
            dest.writeInt(this.f34697d);
        }

        public RemoteCollectionItems(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i3 = parcel.readInt();
            long[] jArr = new long[i3];
            this.f34694a = jArr;
            parcel.readLongArray(jArr);
            Parcelable.Creator CREATOR = RemoteViews.CREATOR;
            Intrinsics.checkNotNullExpressionValue(CREATOR, "CREATOR");
            RemoteViews[] remoteViewsArr = new RemoteViews[i3];
            parcel.readTypedArray(remoteViewsArr, CREATOR);
            this.f34695b = (RemoteViews[]) ArraysKt.requireNoNulls(remoteViewsArr);
            this.f34696c = parcel.readInt() == 1;
            this.f34697d = parcel.readInt();
        }
    }
}
