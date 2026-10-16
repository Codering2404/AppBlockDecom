package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.sun.jna.Function;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpp extends zzjf {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f74489i = {"firebase_", "google_", "ga_"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f74490j = {"_err"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f74491k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SecureRandom f74492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f74493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f74494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MeasurementManagerFutures f74495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f74496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f74497h;

    zzpp(zzic zzicVar) {
        super(zzicVar);
        this.f74497h = null;
        this.f74493d = new AtomicLong(0L);
    }

    static MessageDigest C() {
        MessageDigest messageDigest;
        for (int i3 = 0; i3 < 2; i3++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    static long D(byte[] bArr) {
        Preconditions.m(bArr);
        int length = bArr.length;
        int i3 = 0;
        Preconditions.q(length > 0);
        long j3 = 0;
        for (int i4 = length - 1; i4 >= 0 && i4 >= bArr.length - 8; i4--) {
            j3 += (((long) bArr[i4]) & 255) << i3;
            i3 += 8;
        }
        return j3;
    }

    static boolean E(Context context, boolean z2) {
        Preconditions.m(context);
        return F(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    static boolean F(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static boolean N(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private static boolean O(String str, String[] strArr) {
        Preconditions.m(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean U(String str) {
        return !f74490j[0].equals(str);
    }

    public static ArrayList h0(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzah zzahVar = (zzah) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzahVar.f73386a);
            bundle.putString("origin", zzahVar.f73387b);
            bundle.putLong("creation_timestamp", zzahVar.f73389d);
            bundle.putString("name", zzahVar.f73388c.f74478b);
            zzjh.a(bundle, Preconditions.m(zzahVar.f73388c.zza()));
            bundle.putBoolean("active", zzahVar.f73390f);
            String str = zzahVar.f73391g;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzbg zzbgVar = zzahVar.f73392h;
            if (zzbgVar != null) {
                bundle.putString("timed_out_event_name", zzbgVar.f73484a);
                zzbe zzbeVar = zzbgVar.f73485b;
                if (zzbeVar != null) {
                    bundle.putBundle("timed_out_event_params", zzbeVar.w0());
                }
            }
            bundle.putLong("trigger_timeout", zzahVar.f73393i);
            zzbg zzbgVar2 = zzahVar.f73394j;
            if (zzbgVar2 != null) {
                bundle.putString("triggered_event_name", zzbgVar2.f73484a);
                zzbe zzbeVar2 = zzbgVar2.f73485b;
                if (zzbeVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzbeVar2.w0());
                }
            }
            bundle.putLong("triggered_timestamp", zzahVar.f73388c.f74479c);
            bundle.putLong("time_to_live", zzahVar.f73395k);
            zzbg zzbgVar3 = zzahVar.f73396l;
            if (zzbgVar3 != null) {
                bundle.putString("expired_event_name", zzbgVar3.f73484a);
                zzbe zzbeVar3 = zzbgVar3.f73485b;
                if (zzbeVar3 != null) {
                    bundle.putBundle("expired_event_params", zzbeVar3.w0());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static boolean j0(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.m(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void k0(zzlu zzluVar, Bundle bundle, boolean z2) {
        if (bundle != null && zzluVar != null) {
            if (!bundle.containsKey("_sc") || z2) {
                String str = zzluVar.f74183a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzluVar.f74184b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzluVar.f74185c);
                return;
            }
            z2 = false;
        }
        if (bundle != null && zzluVar == null && z2) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static final boolean m0(Bundle bundle, int i3) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i3);
        return true;
    }

    private final Object n0(int i3, Object obj, boolean z2, boolean z3, String str) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return q(obj.toString(), i3, z2);
        }
        if (!z3 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleQ = Q((Bundle) parcelable, null);
                if (!bundleQ.isEmpty()) {
                    arrayList.add(bundleQ);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final int o0(String str) {
        if ("_ldl".equals(str)) {
            this.f73997a.w();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.f73997a.w();
            return Function.MAX_NARGS;
        }
        if ("_lgclid".equals(str)) {
            this.f73997a.w();
            return 100;
        }
        this.f73997a.w();
        return 36;
    }

    static boolean r0(String str) {
        Preconditions.g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    final void A(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            zzic zzicVar = this.f73997a;
            zzicVar.a().t().c("Not putting event parameter. Invalid value type. name, type", zzicVar.D().b(str), simpleName);
        }
    }

    final int A0(String str) {
        if (!u0("event param", str)) {
            return 3;
        }
        if (!v0("event param", null, null, str)) {
            return 14;
        }
        this.f73997a.w();
        return !w0("event param", 40, str) ? 3 : 0;
    }

    final void B(zzpo zzpoVar, String str, int i3, String str2, String str3, int i4) {
        Bundle bundle = new Bundle();
        m0(bundle, i3);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i3 == 6 || i3 == 7 || i3 == 2) {
            bundle.putLong("_el", i4);
        }
        zzpoVar.a(str, "_err", bundle);
    }

    final boolean B0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    final boolean C0(String str, String str2, int i3, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i3) {
                this.f73997a.a().t().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    final void D0(String str, String str2, String str3, Bundle bundle, List list, boolean z2) {
        int iZ0;
        String str4;
        int iR;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        zzic zzicVar = this.f73997a;
        int i3 = true != zzicVar.w().f73997a.C().V(231100000, true) ? 0 : 35;
        int i4 = 0;
        boolean z3 = false;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str5)) {
                iZ0 = !z2 ? z0(str5) : 0;
                if (iZ0 == 0) {
                    iZ0 = A0(str5);
                }
            } else {
                iZ0 = 0;
            }
            if (iZ0 != 0) {
                x(bundle, iZ0, str5, iZ0 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (B0(bundle.get(str5))) {
                    zzicVar.a().t().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    iR = 22;
                    str4 = null;
                } else {
                    str4 = null;
                    iR = r(str, str2, str5, bundle.get(str5), bundle, list2, z2, false);
                }
                if (iR != 0 && !"_ev".equals(str5)) {
                    x(bundle, iR, str5, bundle.get(str5));
                    bundle.remove(str5);
                } else if (r0(str5) && !O(str5, zzjn.f74025d)) {
                    i4++;
                    if (!V(231100000, true)) {
                        zzicVar.a().q().c("Item array not supported on client's version of Google Play Services (Android Only)", zzicVar.D().a(str2), zzicVar.D().e(bundle));
                        m0(bundle, 23);
                        bundle.remove(str5);
                    } else if (i4 > i3) {
                        if (!zzicVar.w().H(str4, zzfy.f73636f1) || !z3) {
                            zzgs zzgsVarQ = zzicVar.a().q();
                            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i3);
                            sb.append(" item-scoped custom params");
                            zzgsVarQ.c(sb.toString(), zzicVar.D().a(str2), zzicVar.D().e(bundle));
                        }
                        m0(bundle, 28);
                        bundle.remove(str5);
                        list2 = list;
                        z3 = true;
                    }
                }
            }
            list2 = list;
        }
    }

    final boolean G() {
        h();
        return J() == 1;
    }

    final MeasurementManagerFutures H() {
        if (this.f74495f == null) {
            this.f74495f = MeasurementManagerFutures.a(this.f73997a.d());
        }
        return this.f74495f;
    }

    final int I() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    final long J() {
        long j3;
        h();
        if (!L(this.f73997a.L().q())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j3 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j3 = 8;
        } else {
            zzic zzicVar = this.f73997a;
            int I = I();
            zzicVar.w();
            j3 = I < ((Integer) zzfy.f73656m0.b(null)).intValue() ? 16L : 0L;
        }
        if (!M("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j3 |= 2;
        }
        if (j3 == 0 && !K()) {
            j3 = 64;
        }
        if (j3 == 0) {
            return 1L;
        }
        return j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean K() {
        Object e3;
        Integer num;
        if (this.f74496g == null) {
            MeasurementManagerFutures measurementManagerFuturesH = H();
            boolean z2 = false;
            if (measurementManagerFuturesH == null) {
                return false;
            }
            try {
                num = (Integer) measurementManagerFuturesH.b().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z2 = true;
                        }
                    } catch (InterruptedException e4) {
                        e3 = e4;
                        this.f73997a.a().r().b("Measurement manager api exception", e3);
                        this.f74496g = Boolean.FALSE;
                    } catch (CancellationException e5) {
                        e3 = e5;
                        this.f73997a.a().r().b("Measurement manager api exception", e3);
                        this.f74496g = Boolean.FALSE;
                    } catch (ExecutionException e6) {
                        e3 = e6;
                        this.f73997a.a().r().b("Measurement manager api exception", e3);
                        this.f74496g = Boolean.FALSE;
                    } catch (TimeoutException e7) {
                        e3 = e7;
                        this.f73997a.a().r().b("Measurement manager api exception", e3);
                        this.f74496g = Boolean.FALSE;
                    }
                }
                this.f74496g = Boolean.valueOf(z2);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e8) {
                e3 = e8;
                num = null;
            }
            this.f73997a.a().w().b("Measurement manager api status result", num);
        }
        return this.f74496g.booleanValue();
    }

    final boolean L(String str) {
        String str2 = (String) zzfy.f73668s0.b(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    final boolean M(String str) {
        h();
        zzic zzicVar = this.f73997a;
        if (Wrappers.a(zzicVar.d()).a(str) == 0) {
            return true;
        }
        zzicVar.a().v().b("Permission not granted", str);
        return false;
    }

    final boolean P(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzic zzicVar = this.f73997a;
        String strI = zzicVar.w().i();
        zzicVar.c();
        return strI.equals(str);
    }

    final Bundle Q(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objS = s(str2, bundle.get(str2));
                if (objS == null) {
                    zzic zzicVar = this.f73997a;
                    zzicVar.a().t().b("Param value can't be null", zzicVar.D().b(str2));
                } else {
                    A(bundle2, str2, objS);
                }
            }
        }
        return bundle2;
    }

    final zzbg R(String str, String str2, Bundle bundle, String str3, long j3, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (x0(str2) != 0) {
            zzic zzicVar = this.f73997a;
            zzicVar.a().o().b("Invalid conditional property event name", zzicVar.D().c(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleT = t(str, str2, bundle2, CollectionUtils.a("_o"), true);
        if (z2) {
            bundleT = Q(bundleT, str);
        }
        Preconditions.m(bundleT);
        return new zzbg(str2, new zzbe(bundleT), str3, j3);
    }

    final boolean S(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoF = Wrappers.a(context).f(str, 64);
            if (packageInfoF == null || (signatureArr = packageInfoF.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e3) {
            this.f73997a.a().o().b("Package name not found", e3);
            return true;
        } catch (CertificateException e4) {
            this.f73997a.a().o().b("Error obtaining certificate", e4);
            return true;
        }
    }

    final byte[] T(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final boolean V(int i3, boolean z2) {
        Boolean boolX = this.f73997a.J().x();
        if (W() < i3 / 1000) {
            return (boolX == null || boolX.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int W() {
        if (this.f74497h == null) {
            this.f74497h = Integer.valueOf(GoogleApiAvailabilityLight.h().b(this.f73997a.d()) / 1000);
        }
        return this.f74497h.intValue();
    }

    public final int X(int i3) {
        return GoogleApiAvailabilityLight.h().j(this.f73997a.d(), 12451000);
    }

    public final long Y(long j3, long j4) {
        return (j3 + (j4 * 60000)) / 86400000;
    }

    final void Z(Bundle bundle, long j3) {
        long j4 = bundle.getLong("_et");
        if (j4 != 0) {
            this.f73997a.a().r().b("Params already contained engagement", Long.valueOf(j4));
        } else {
            j4 = 0;
        }
        bundle.putLong("_et", j3 + j4);
    }

    public final void a0(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning string value to wrapper", e3);
        }
    }

    public final void b0(com.google.android.gms.internal.measurement.zzcu zzcuVar, long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j3);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning long value to wrapper", e3);
        }
    }

    public final void c0(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i3);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning int value to wrapper", e3);
        }
    }

    public final void d0(com.google.android.gms.internal.measurement.zzcu zzcuVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning byte array to wrapper", e3);
        }
    }

    public final void e0(com.google.android.gms.internal.measurement.zzcu zzcuVar, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z2);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning boolean value to wrapper", e3);
        }
    }

    public final void f0(com.google.android.gms.internal.measurement.zzcu zzcuVar, Bundle bundle) {
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning bundle value to wrapper", e3);
        }
    }

    public final void g0(com.google.android.gms.internal.measurement.zzcu zzcuVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e3) {
            this.f73997a.a().r().b("Error returning bundle list to wrapper", e3);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final boolean i() {
        return true;
    }

    public final URL i0(long j3, String str, String str2, long j4, String str3) {
        try {
            Preconditions.g(str2);
            Preconditions.g(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 133005L, Integer.valueOf(W())), str2, str, Long.valueOf(j4));
            if (str.equals(this.f73997a.w().j())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e3) {
            e = e3;
            this.f73997a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e4) {
            e = e4;
            this.f73997a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final void j() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.f73997a.a().r().a("Utils falling back to Random for random id");
            }
        }
        this.f74493d.set(jNextLong);
    }

    final String l0() {
        byte[] bArr = new byte[16];
        q0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f73997a.a().q().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.m(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        this.f73997a.a().q().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgu.x(str));
        return false;
    }

    final boolean p(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.m(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final long p0() {
        long andIncrement;
        long j3;
        AtomicLong atomicLong = this.f74493d;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f74493d;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNextLong = new Random(System.nanoTime() ^ this.f73997a.e().currentTimeMillis()).nextLong();
            int i3 = this.f74494e + 1;
            this.f74494e = i3;
            j3 = jNextLong + ((long) i3);
        }
        return j3;
    }

    public final String q(String str, int i3, boolean z2) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i3) {
            return str;
        }
        if (z2) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i3))).concat("...");
        }
        return null;
    }

    final SecureRandom q0() {
        h();
        if (this.f74492c == null) {
            this.f74492c = new SecureRandom();
        }
        return this.f74492c;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int r(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Object r16, android.os.Bundle r17, java.util.List r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpp.r(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    final Object s(String str, Object obj) {
        if ("_ev".equals(str)) {
            return n0(this.f73997a.w().y(null, false), obj, true, true, null);
        }
        return n0(N(str) ? this.f73997a.w().y(null, false) : this.f73997a.w().x(null, false), obj, false, true, null);
    }

    final Bundle t(String str, String str2, Bundle bundle, List list, boolean z2) {
        int iZ0;
        List list2 = list;
        boolean zO = O(str2, zzjm.f74021d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        zzic zzicVar = this.f73997a;
        int iV = zzicVar.w().v();
        int i3 = 0;
        boolean z3 = false;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str3)) {
                iZ0 = !z2 ? z0(str3) : 0;
                if (iZ0 == 0) {
                    iZ0 = A0(str3);
                }
            } else {
                iZ0 = 0;
            }
            if (iZ0 != 0) {
                x(bundle2, iZ0, str3, iZ0 == 3 ? str3 : null);
                bundle2.remove(str3);
            } else {
                int iR = r(str, str2, str3, bundle.get(str3), bundle2, list2, z2, zO);
                if (iR == 17) {
                    x(bundle2, 17, str3, Boolean.FALSE);
                } else if (iR != 0 && !"_ev".equals(str3)) {
                    x(bundle2, iR, iR == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (r0(str3) && (i3 = i3 + 1) > iV) {
                    if (!zzicVar.w().H(null, zzfy.f73636f1) || !z3) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iV).length() + 37);
                        sb.append("Event can't contain more than ");
                        sb.append(iV);
                        sb.append(" params");
                        zzicVar.a().q().c(sb.toString(), zzicVar.D().a(str2), zzicVar.D().e(bundle));
                    }
                    m0(bundle2, 5);
                    bundle2.remove(str3);
                    z3 = true;
                }
            }
            list2 = list;
        }
        return bundle2;
    }

    final boolean t0(String str, String str2) {
        if (str2 == null) {
            this.f73997a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f73997a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.f73997a.a().q().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f73997a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final void u(zzgv zzgvVar, int i3) {
        Bundle bundle = zzgvVar.f73742d;
        int i4 = 0;
        boolean z2 = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (r0(str) && (i4 = i4 + 1) > i3) {
                zzic zzicVar = this.f73997a;
                if (!zzicVar.w().H(null, zzfy.f73636f1) || !z2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i3);
                    sb.append(" params");
                    zzicVar.a().q().c(sb.toString(), zzicVar.D().a(zzgvVar.f73739a), zzicVar.D().e(bundle));
                    m0(bundle, 5);
                }
                bundle.remove(str);
                z2 = true;
            }
        }
    }

    final boolean u0(String str, String str2) {
        if (str2 == null) {
            this.f73997a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f73997a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.f73997a.a().q().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f73997a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final void v(Parcelable[] parcelableArr, int i3) {
        Preconditions.m(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i4 = 0;
            boolean z2 = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (r0(str) && !O(str, zzjn.f74025d) && (i4 = i4 + 1) > i3) {
                    zzic zzicVar = this.f73997a;
                    if (!zzicVar.w().H(null, zzfy.f73636f1) || !z2) {
                        zzgs zzgsVarQ = zzicVar.a().q();
                        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i3);
                        sb.append(" item-scoped custom parameters");
                        zzgsVarQ.c(sb.toString(), zzicVar.D().b(str), zzicVar.D().e(bundle));
                    }
                    m0(bundle, 28);
                    bundle.remove(str);
                    z2 = true;
                }
            }
        }
    }

    final boolean v0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f73997a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.m(str2);
        String[] strArr3 = f74489i;
        for (int i3 = 0; i3 < 3; i3++) {
            if (str2.startsWith(strArr3[i3])) {
                this.f73997a.a().q().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !O(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && O(str2, strArr2)) {
            return true;
        }
        this.f73997a.a().q().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    final void w(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.f73997a.C().A(bundle, str, bundle2.get(str));
            }
        }
    }

    final boolean w0(String str, int i3, String str2) {
        if (str2 == null) {
            this.f73997a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i3) {
            return true;
        }
        this.f73997a.a().q().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i3), str2);
        return false;
    }

    final void x(Bundle bundle, int i3, String str, Object obj) {
        if (m0(bundle, i3)) {
            this.f73997a.w();
            bundle.putString("_ev", q(str, 40, true));
            if (obj != null) {
                Preconditions.m(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    final int x0(String str) {
        if (!u0("event", str)) {
            return 2;
        }
        if (!v0("event", zzjm.f74018a, zzjm.f74019b, str)) {
            return 13;
        }
        this.f73997a.w();
        return !w0("event", 40, str) ? 2 : 0;
    }

    final int y(String str, Object obj) {
        return "_ldl".equals(str) ? C0("user property referrer", str, o0(str), obj) : C0("user property", str, o0(str), obj) ? 0 : 7;
    }

    final int y0(String str) {
        if (!u0("user property", str)) {
            return 6;
        }
        if (!v0("user property", zzjo.f74026a, null, str)) {
            return 15;
        }
        this.f73997a.w();
        return !w0("user property", 24, str) ? 6 : 0;
    }

    final Object z(String str, Object obj) {
        return "_ldl".equals(str) ? n0(o0(str), obj, true, false, null) : n0(o0(str), obj, false, false, null);
    }

    final int z0(String str) {
        if (!t0("event param", str)) {
            return 3;
        }
        if (!v0("event param", null, null, str)) {
            return 14;
        }
        this.f73997a.w();
        return !w0("event param", 40, str) ? 3 : 0;
    }

    final Bundle s0(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter(vgWWUoTKYyuC.uFzeXwzSWeGFIV);
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString(AppLovinEventTypes.USER_VIEWED_CONTENT, queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            for (String str2 : uri.getQueryParameterNames()) {
                if (str2.startsWith("gad_")) {
                    String queryParameter19 = uri.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter19)) {
                        bundle.putString(str2, queryParameter19);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e3) {
            this.f73997a.a().r().b("Install referrer url isn't a hierarchical URI", e3);
            return null;
        }
    }
}
