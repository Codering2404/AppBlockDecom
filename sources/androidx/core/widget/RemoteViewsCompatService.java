package androidx.core.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.util.Base64;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.core.remoteviews.R;
import androidx.core.widget.RemoteViewsCompat;
import androidx.core.widget.RemoteViewsCompatService;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class RemoteViewsCompatService extends RemoteViewsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f34698a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class RemoteViewsCompatServiceData {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f34699d = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f34700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f34701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f34702c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object a(byte[] bytes, Function1 creator) {
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                Intrinsics.checkNotNullParameter(creator, "creator");
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
                try {
                    parcelObtain.unmarshall(bytes, 0, bytes.length);
                    parcelObtain.setDataPosition(0);
                    return creator.invoke(parcelObtain);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public final Object b(String hexString, Function1 creator) {
                Intrinsics.checkNotNullParameter(hexString, "hexString");
                Intrinsics.checkNotNullParameter(creator, "creator");
                byte[] bArrDecode = Base64.decode(hexString, 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(hexString, Base64.DEFAULT)");
                return a(bArrDecode, creator);
            }

            public final String c(int i3, int i4) {
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                sb.append(':');
                sb.append(i4);
                return sb.toString();
            }

            public final SharedPreferences d(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.core.widget.prefs.RemoteViewsCompat", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…S_FILENAME, MODE_PRIVATE)");
                return sharedPreferences;
            }

            public final Long e(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                try {
                    return Long.valueOf(PackageInfoCompat.a(context.getPackageManager().getPackageInfo(context.getPackageName(), 0)));
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.e("RemoteViewsCompatServic", "Couldn't retrieve version code for " + context.getPackageManager(), e3);
                    return null;
                }
            }

            private Companion() {
            }

            public final RemoteViewsCompat.RemoteCollectionItems f(Context context, int i3, int i4) {
                Intrinsics.checkNotNullParameter(context, "context");
                String string = d(context).getString(c(i3, i4), null);
                if (string == null) {
                    Log.w("RemoteViewsCompatServic", "No collection items were stored for widget " + i3);
                    return null;
                }
                RemoteViewsCompatServiceData remoteViewsCompatServiceData = (RemoteViewsCompatServiceData) b(string, new Function1<Parcel, RemoteViewsCompatServiceData>() { // from class: androidx.core.widget.RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion$load$data$1
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final RemoteViewsCompatService.RemoteViewsCompatServiceData invoke(Parcel it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RemoteViewsCompatService.RemoteViewsCompatServiceData(it);
                    }
                });
                if (!Intrinsics.areEqual(Build.VERSION.INCREMENTAL, remoteViewsCompatServiceData.f34701b)) {
                    Log.w("RemoteViewsCompatServic", "Android version code has changed, not using stored collection items for widget " + i3);
                    return null;
                }
                Long lE = e(context);
                if (lE == null) {
                    Log.w("RemoteViewsCompatServic", "Couldn't get version code, not using stored collection items for widget " + i3);
                    return null;
                }
                if (lE.longValue() != remoteViewsCompatServiceData.f34702c) {
                    Log.w("RemoteViewsCompatServic", qRMDmh.ICh + i3);
                    return null;
                }
                try {
                    return (RemoteViewsCompat.RemoteCollectionItems) a(remoteViewsCompatServiceData.f34700a, new Function1<Parcel, RemoteViewsCompat.RemoteCollectionItems>() { // from class: androidx.core.widget.RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion$load$1
                        @Override // kotlin.jvm.functions.Function1
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final RemoteViewsCompat.RemoteCollectionItems invoke(Parcel it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return new RemoteViewsCompat.RemoteCollectionItems(it);
                        }
                    });
                } catch (Throwable th) {
                    Log.e("RemoteViewsCompatServic", "Unable to deserialize stored collection items for widget " + i3, th);
                    return null;
                }
            }
        }

        public RemoteViewsCompatServiceData(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            byte[] bArr = new byte[parcel.readInt()];
            this.f34700a = bArr;
            parcel.readByteArray(bArr);
            String string = parcel.readString();
            Intrinsics.checkNotNull(string);
            this.f34701b = string;
            this.f34702c = parcel.readLong();
        }

        public final void d(Parcel dest) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.f34700a.length);
            dest.writeByteArray(this.f34700a);
            dest.writeString(this.f34701b);
            dest.writeLong(this.f34702c);
        }
    }

    @Override // android.widget.RemoteViewsService
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("appWidgetId", -1);
        if (intExtra == -1) {
            throw new IllegalStateException("No app widget id was present in the intent");
        }
        int intExtra2 = intent.getIntExtra("androidx.core.widget.extra.view_id", -1);
        if (intExtra2 != -1) {
            return new RemoteViewsCompatServiceViewFactory(this, intExtra, intExtra2);
        }
        throw new IllegalStateException("No view id was present in the intent");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class RemoteViewsCompatServiceViewFactory implements RemoteViewsService.RemoteViewsFactory {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Companion f34706e = new Companion(null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final RemoteViewsCompat.RemoteCollectionItems f34707f = new RemoteViewsCompat.RemoteCollectionItems(new long[0], new RemoteViews[0], false, 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f34708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RemoteViewsCompat.RemoteCollectionItems f34711d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public RemoteViewsCompatServiceViewFactory(Context mContext, int i3, int i4) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.f34708a = mContext;
            this.f34709b = i3;
            this.f34710c = i4;
            this.f34711d = f34707f;
        }

        private final void b() {
            RemoteViewsCompat.RemoteCollectionItems remoteCollectionItemsF = RemoteViewsCompatServiceData.f34699d.f(this.f34708a, this.f34709b, this.f34710c);
            if (remoteCollectionItemsF == null) {
                remoteCollectionItemsF = f34707f;
            }
            this.f34711d = remoteCollectionItemsF;
        }

        public Void a() {
            return null;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            return this.f34711d.a();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int i3) {
            try {
                return this.f34711d.b(i3);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return -1L;
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public /* bridge */ /* synthetic */ RemoteViews getLoadingView() {
            return (RemoteViews) a();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public RemoteViews getViewAt(int i3) {
            try {
                return this.f34711d.c(i3);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return new RemoteViews(this.f34708a.getPackageName(), R.layout.f34248a);
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return this.f34711d.d();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return this.f34711d.e();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
            b();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            b();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
        }
    }
}
