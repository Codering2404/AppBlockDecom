package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.applovin.sdk.AppLovinEventTypes;
import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f34016k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f34017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f34018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f34019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f34020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f34021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f34022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f34023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f34024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f34025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f34026j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static int a(Object obj) {
            return Api28Impl.a(obj);
        }

        static String b(Object obj) {
            return Api28Impl.b(obj);
        }

        static int c(Object obj) {
            return Api28Impl.c(obj);
        }

        static Uri d(Object obj) {
            return Api28Impl.d(obj);
        }

        static Icon e(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f34017a) {
                case -1:
                    return (Icon) iconCompat.f34018b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f34018b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.h(), iconCompat.f34021e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f34018b, iconCompat.f34021e, iconCompat.f34022f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f34018b);
                    break;
                case 5:
                    iconCreateWithBitmap = Api26Impl.a((Bitmap) iconCompat.f34018b);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        iconCreateWithBitmap = Api30Impl.a(iconCompat.j());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.j());
                        }
                        InputStream inputStreamK = iconCompat.k(context);
                        if (inputStreamK == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.j());
                        }
                        iconCreateWithBitmap = Api26Impl.a(BitmapFactory.decodeStream(inputStreamK));
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f34023g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f34024h;
            if (mode != IconCompat.f34016k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    public IconCompat() {
        this.f34017a = -1;
        this.f34019c = null;
        this.f34020d = null;
        this.f34021e = 0;
        this.f34022f = 0;
        this.f34023g = null;
        this.f34024h = f34016k;
        this.f34025i = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z2) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f3 = iMin;
        float f4 = 0.5f * f3;
        float f5 = 0.9166667f * f4;
        if (z2) {
            float f6 = 0.010416667f * f3;
            paint.setColor(0);
            paint.setShadowLayer(f6, 0.0f, f3 * 0.020833334f, 1023410176);
            canvas.drawCircle(f4, f4, f5, paint);
            paint.setShadowLayer(f6, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f4, f4, f5, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f4, f4, f5, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        ObjectsCompat.c(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f34018b = bitmap;
        return iconCompat;
    }

    public static IconCompat c(Bitmap bitmap) {
        ObjectsCompat.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f34018b = bitmap;
        return iconCompat;
    }

    public static IconCompat d(Context context, int i3) {
        ObjectsCompat.c(context);
        return e(context.getResources(), context.getPackageName(), i3);
    }

    public static IconCompat e(Resources resources, String str, int i3) {
        ObjectsCompat.c(str);
        if (i3 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f34021e = i3;
        if (resources != null) {
            try {
                iconCompat.f34018b = resources.getResourceName(i3);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f34018b = str;
        }
        iconCompat.f34026j = str;
        return iconCompat;
    }

    private static String q(int i3) {
        switch (i3) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap f() {
        int i3 = this.f34017a;
        if (i3 == -1) {
            Object obj = this.f34018b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i3 == 1) {
            return (Bitmap) this.f34018b;
        }
        if (i3 == 5) {
            return a((Bitmap) this.f34018b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int g() {
        int i3 = this.f34017a;
        if (i3 == -1) {
            return Api23Impl.a(this.f34018b);
        }
        if (i3 == 2) {
            return this.f34021e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String h() {
        int i3 = this.f34017a;
        if (i3 == -1) {
            return Api23Impl.b(this.f34018b);
        }
        if (i3 == 2) {
            String str = this.f34026j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f34018b).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0] : this.f34026j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int i() {
        int i3 = this.f34017a;
        return i3 == -1 ? Api23Impl.c(this.f34018b) : i3;
    }

    public Uri j() {
        int i3 = this.f34017a;
        if (i3 == -1) {
            return Api23Impl.d(this.f34018b);
        }
        if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.f34018b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream k(Context context) {
        Uri uriJ = j();
        String scheme = uriJ.getScheme();
        if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriJ);
            } catch (Exception e3) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriJ, e3);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f34018b));
        } catch (FileNotFoundException e4) {
            Log.w("IconCompat", "Unable to load image from path: " + uriJ, e4);
            return null;
        }
    }

    public void l() {
        this.f34024h = PorterDuff.Mode.valueOf(this.f34025i);
        switch (this.f34017a) {
            case -1:
                Parcelable parcelable = this.f34020d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f34018b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f34020d;
                if (parcelable2 != null) {
                    this.f34018b = parcelable2;
                    return;
                }
                byte[] bArr = this.f34019c;
                this.f34018b = bArr;
                this.f34017a = 3;
                this.f34021e = 0;
                this.f34022f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f34019c, Charset.forName("UTF-16"));
                this.f34018b = str;
                if (this.f34017a == 2 && this.f34026j == null) {
                    this.f34026j = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f34018b = this.f34019c;
                return;
        }
    }

    public void m(boolean z2) {
        this.f34025i = this.f34024h.name();
        switch (this.f34017a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f34020d = (Parcelable) this.f34018b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z2) {
                    this.f34020d = (Parcelable) this.f34018b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f34018b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f34019c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f34019c = ((String) this.f34018b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f34019c = (byte[]) this.f34018b;
                return;
            case 4:
            case 6:
                this.f34019c = this.f34018b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Bundle n() {
        Bundle bundle = new Bundle();
        switch (this.f34017a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f34018b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f34018b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f34018b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f34018b);
                break;
        }
        bundle.putInt("type", this.f34017a);
        bundle.putInt("int1", this.f34021e);
        bundle.putInt("int2", this.f34022f);
        bundle.putString("string1", this.f34026j);
        ColorStateList colorStateList = this.f34023g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f34024h;
        if (mode != f34016k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public Icon o() {
        return p(null);
    }

    public Icon p(Context context) {
        return Api23Impl.e(this, context);
    }

    public String toString() {
        if (this.f34017a == -1) {
            return String.valueOf(this.f34018b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(q(this.f34017a));
        switch (this.f34017a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f34018b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f34018b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f34026j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(g())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f34021e);
                if (this.f34022f != 0) {
                    sb.append(" off=");
                    sb.append(this.f34022f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f34018b);
                break;
        }
        if (this.f34023g != null) {
            sb.append(" tint=");
            sb.append(this.f34023g);
        }
        if (this.f34024h != f34016k) {
            sb.append(" mode=");
            sb.append(this.f34024h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i3) {
        this.f34019c = null;
        this.f34020d = null;
        this.f34021e = 0;
        this.f34022f = 0;
        this.f34023g = null;
        this.f34024h = f34016k;
        this.f34025i = null;
        this.f34017a = i3;
    }
}
