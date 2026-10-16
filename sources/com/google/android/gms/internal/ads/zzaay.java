package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaay extends zzabe implements zznb {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgyg zzc = zzgyg.zzc(zzaah.zza);
    public final Context zza;
    private final Object zzd;
    private zzaam zze;
    private Thread zzf;
    private zzacm zzg;
    private zzd zzh;
    private Boolean zzi;
    private final zzzt zzj;

    public zzaay(Context context) {
        zzzt zzztVar = new zzzt();
        zzaam zzaamVar = zzaam.zzJ;
        this.zzd = new Object();
        byte[] bArr = null;
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzztVar;
        if (zzaamVar != null) {
            this.zze = zzaamVar;
        } else {
            zzaal zzaalVar = new zzaal(zzaamVar, bArr);
            zzaalVar.zzx((zzbl) zzaamVar);
            this.zze = new zzaam(zzaalVar, bArr);
        }
        this.zzh = zzd.zza;
        if (this.zze.zzU && context == null) {
            zzeg.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    private static Pair zzA(zzaaz[] zzaazVarArr, int i3) {
        for (int i4 = 0; i4 < 2; i4++) {
            zzaaz zzaazVar = zzaazVarArr[i4];
            if (zzaazVar != null && zzaazVar.zza.zzc == i3) {
                return Pair.create(zzaazVar, Integer.valueOf(i4));
            }
        }
        return null;
    }

    private static final Pair zzB(int i3, zzabd zzabdVar, int[][][] iArr, zzaap zzaapVar, Comparator comparator) {
        RandomAccess randomAccessZzj;
        zzabd zzabdVar2 = zzabdVar;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < 2) {
            if (i3 == zzabdVar2.zza(i4)) {
                zzzn zzznVarZzb = zzabdVar2.zzb(i4);
                for (int i5 = 0; i5 < zzznVarZzb.zzb; i5++) {
                    zzbg zzbgVarZza = zzznVarZzb.zza(i5);
                    List listZza = zzaapVar.zza(i4, zzbgVarZza, iArr[i4][i5]);
                    int i6 = zzbgVarZza.zza;
                    boolean[] zArr = new boolean[i6];
                    int i7 = 0;
                    while (i7 < i6) {
                        int i8 = i7 + 1;
                        zzaaq zzaaqVar = (zzaaq) listZza.get(i7);
                        int iZza = zzaaqVar.zza();
                        if (!zArr[i7] && iZza != 0) {
                            if (iZza == 1) {
                                randomAccessZzj = zzgwm.zzj(zzaaqVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzaaqVar);
                                for (int i9 = i8; i9 < i6; i9++) {
                                    zzaaq zzaaqVar2 = (zzaaq) listZza.get(i9);
                                    if (zzaaqVar2.zza() == 2 && zzaaqVar.zzc(zzaaqVar2)) {
                                        arrayList2.add(zzaaqVar2);
                                        zArr[i9] = true;
                                    }
                                }
                                randomAccessZzj = arrayList2;
                            }
                            arrayList.add(randomAccessZzj);
                        }
                        i7 = i8;
                    }
                }
            }
            i4++;
            zzabdVar2 = zzabdVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr2[i10] = ((zzaaq) list.get(i10)).zzc;
        }
        zzaaq zzaaqVar3 = (zzaaq) list.get(0);
        return Pair.create(new zzaaz(zzaaqVar3.zzb, iArr2, 0), Integer.valueOf(zzaaqVar3.zza));
    }

    protected static String zzi(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int zzj(zzv zzvVar, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(zzvVar.zzd)) {
            return 4;
        }
        String strZzi = zzi(str);
        String strZzi2 = zzi(zzvVar.zzd);
        if (strZzi2 == null || strZzi == null) {
            return (z2 && strZzi2 == null) ? 1 : 0;
        }
        if (strZzi2.startsWith(strZzi) || strZzi.startsWith(strZzi2)) {
            return 3;
        }
        String str2 = zzfl.zza;
        return strZzi2.split("-", 2)[0].equals(strZzi.split("-", 2)[0]) ? 2 : 0;
    }

    static /* synthetic */ int zzm(int i3, int i4) {
        return (i3 == 0 || i3 != i4) ? Integer.bitCount(i3 & i4) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ int zzn(com.google.android.gms.internal.ads.zzv r5, com.google.android.gms.internal.ads.zzgwm r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            int r2 = r6.size()
            if (r1 >= r2) goto L2a
            r2 = r0
        L9:
            java.util.List r3 = r5.zzc
            int r4 = r3.size()
            if (r2 >= r4) goto L27
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.ads.zzx r3 = (com.google.android.gms.internal.ads.zzx) r3
            java.lang.String r3 = r3.zzb
            java.lang.Object r4 = r6.get(r1)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L24
            return r1
        L24:
            int r2 = r2 + 1
            goto L9
        L27:
            int r1 = r1 + 1
            goto L2
        L2a:
            r5 = 2147483647(0x7fffffff, float:NaN)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaay.zzn(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzgwm):int");
    }

    protected static final zzaaz zzp(int i3, zzzn zzznVar, int[][] iArr, zzaam zzaamVar) throws zzjk {
        int i4 = zzaamVar.zzw.zzb;
        int i5 = 0;
        zzbg zzbgVar = null;
        zzaak zzaakVar = null;
        for (int i6 = 0; i6 < zzznVar.zzb; i6++) {
            zzbg zzbgVarZza = zzznVar.zza(i6);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < zzbgVarZza.zza; i7++) {
                if (zznc.zzac(iArr2[i7], zzaamVar.zzV)) {
                    zzaak zzaakVar2 = new zzaak(zzbgVarZza.zza(i7), iArr2[i7]);
                    if (zzaakVar == null || zzaakVar2.compareTo(zzaakVar) > 0) {
                        zzbgVar = zzbgVarZza;
                        i5 = i7;
                        zzaakVar = zzaakVar2;
                    }
                }
            }
        }
        if (zzbgVar == null) {
            return null;
        }
        return new zzaaz(zzbgVar, new int[]{i5}, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public final void zzk() {
        boolean z2;
        zzacm zzacmVar;
        synchronized (this.zzd) {
            try {
                z2 = false;
                if (this.zze.zzU && Build.VERSION.SDK_INT >= 32 && (zzacmVar = this.zzg) != null && zzacmVar.zzb()) {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            zzt();
        }
    }

    private static void zzw(zzabd zzabdVar, zzbl zzblVar, zzaaz[] zzaazVarArr) {
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < 2; i3++) {
            zzx(zzabdVar.zzb(i3), zzblVar, map);
        }
        zzx(zzabdVar.zze(), zzblVar, map);
        for (int i4 = 0; i4 < 2; i4++) {
            if (((zzbh) map.get(Integer.valueOf(zzabdVar.zza(i4)))) != null) {
                throw null;
            }
        }
    }

    private static void zzx(zzzn zzznVar, zzbl zzblVar, Map map) {
        for (int i3 = 0; i3 < zzznVar.zzb; i3++) {
            if (((zzbh) zzblVar.zzH.get(zzznVar.zza(i3))) != null) {
                throw null;
            }
        }
    }

    private static void zzy(zzabd zzabdVar, zzaam zzaamVar, zzaaz[] zzaazVarArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            zzzn zzznVarZzb = zzabdVar.zzb(i3);
            if (zzaamVar.zzb(i3, zzznVarZzb)) {
                if (zzaamVar.zzc(i3, zzznVarZzb) != null) {
                    throw null;
                }
                zzaazVarArr[i3] = null;
            }
        }
    }

    private static void zzz(zzabd zzabdVar, zzaam zzaamVar, zzaaz[] zzaazVarArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            int iZza = zzabdVar.zza(i3);
            if (zzaamVar.zza(i3) || zzaamVar.zzI.contains(Integer.valueOf(iZza))) {
                zzaazVarArr[i3] = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zzna zznaVar) {
        synchronized (this.zzd) {
            boolean z2 = this.zze.zzY;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final void zzb() {
        zzacm zzacmVar;
        synchronized (this.zzd) {
            try {
                Thread thread = this.zzf;
                if (thread != null) {
                    zzgtj.zzj(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzacmVar = this.zzg) != null) {
            zzacmVar.zzg();
            this.zzg = null;
        }
        super.zzb();
    }

    public final zzaam zzc() {
        zzaam zzaamVar;
        synchronized (this.zzd) {
            zzaamVar = this.zze;
        }
        return zzaamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final boolean zzd() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final void zze(zzd zzdVar) {
        if (this.zzh.equals(zzdVar)) {
            return;
        }
        this.zzh = zzdVar;
        zzk();
    }

    public final void zzf(zzaal zzaalVar) {
        boolean zEquals;
        zzaam zzaamVar = new zzaam(zzaalVar, null);
        synchronized (this.zzd) {
            zEquals = this.zze.equals(zzaamVar);
            this.zze = zzaamVar;
        }
        if (zEquals) {
            return;
        }
        if (zzaamVar.zzU && this.zza == null) {
            zzeg.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzabe
    protected final Pair zzh(zzabd zzabdVar, int[][][] iArr, final int[] iArr2, zzxk zzxkVar, zzbf zzbfVar) throws zzjk {
        final zzaam zzaamVar;
        final String str;
        zzzt zzztVar;
        int[] iArr3;
        int length;
        zzaba zzabaVarZza;
        int i3;
        int i4;
        final String languageTag;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        final boolean z2;
        Context context3;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzaamVar = this.zze;
        }
        if (this.zzi == null && (context3 = this.zza) != null) {
            this.zzi = Boolean.valueOf(zzfl.zzP(context3));
        }
        if (zzaamVar.zzU && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzacm(this.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzaai
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzk();
                }
            }, this.zzi);
        }
        zzaaz[] zzaazVarArr = new zzaaz[2];
        zzw(zzabdVar, zzaamVar, zzaazVarArr);
        zzy(zzabdVar, zzaamVar, zzaazVarArr);
        zzz(zzabdVar, zzaamVar, zzaazVarArr);
        Pair pairZzA = zzA(zzaazVarArr, 1);
        int i5 = 0;
        if (pairZzA == null) {
            int i6 = 0;
            while (true) {
                if (i6 >= 2) {
                    z2 = false;
                    break;
                }
                if (zzabdVar.zza(i6) == 2 && zzabdVar.zzb(i6).zzb > 0) {
                    z2 = true;
                    break;
                }
                i6++;
            }
            pairZzA = zzB(1, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaad
                @Override // com.google.android.gms.internal.ads.zzaap
                public final /* synthetic */ List zza(int i7, zzbg zzbgVar, int[] iArr4) {
                    final zzaay zzaayVar = this.zza;
                    final zzaam zzaamVar2 = zzaamVar;
                    zzgtk zzgtkVar = new zzgtk() { // from class: com.google.android.gms.internal.ads.zzaag
                        @Override // com.google.android.gms.internal.ads.zzgtk
                        public final /* synthetic */ boolean zza(Object obj) {
                            return zzaayVar.zzl(zzaamVar2, (zzv) obj);
                        }
                    };
                    int i8 = iArr2[i7];
                    int i9 = zzgwm.zzd;
                    zzgwj zzgwjVar = new zzgwj();
                    for (int i10 = 0; i10 < zzbgVar.zza; i10++) {
                        zzgwjVar.zzf(new zzzx(i7, zzbgVar, i10, zzaamVar2, iArr4[i10], z2, zzgtkVar, i8));
                    }
                    return zzgwjVar.zzi();
                }
            }, zzzy.zza);
            if (pairZzA != null) {
                zzaazVarArr[((Integer) pairZzA.second).intValue()] = (zzaaz) pairZzA.first;
            }
        }
        if (pairZzA == null) {
            str = null;
        } else {
            Object obj = pairZzA.first;
            str = ((zzaaz) obj).zza.zza(((zzaaz) obj).zzb[0]).zzd;
        }
        Pair pairZzA2 = zzA(zzaazVarArr, 2);
        Pair pairZzA3 = zzA(zzaazVarArr, 4);
        if (pairZzA2 == null && pairZzA3 == null) {
            int i7 = zzaamVar.zzw.zzb;
            final Point pointZzR = (!zzaamVar.zzk || (context2 = this.zza) == null) ? null : zzfl.zzR(context2);
            Pair pairZzB = zzB(2, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaac
                /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
                @Override // com.google.android.gms.internal.ads.zzaap
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final /* synthetic */ java.util.List zza(int r18, com.google.android.gms.internal.ads.zzbg r19, int[] r20) {
                    /*
                        Method dump skipped, instruction units count: 207
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaac.zza(int, com.google.android.gms.internal.ads.zzbg, int[]):java.util.List");
                }
            }, zzaab.zza);
            Pair pairZzB2 = pairZzB == null ? zzB(4, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaaf
                @Override // com.google.android.gms.internal.ads.zzaap
                public final /* synthetic */ List zza(int i8, zzbg zzbgVar, int[] iArr4) {
                    int i9 = zzaay.zzb;
                    int i10 = zzgwm.zzd;
                    zzgwj zzgwjVar = new zzgwj();
                    for (int i11 = 0; i11 < zzbgVar.zza; i11++) {
                        zzgwjVar.zzf(new zzaaj(i8, zzbgVar, i11, zzaamVar, iArr4[i11]));
                    }
                    return zzgwjVar.zzi();
                }
            }, zzzz.zza) : null;
            if (pairZzB2 != null) {
                zzaazVarArr[((Integer) pairZzB2.second).intValue()] = (zzaaz) pairZzB2.first;
            } else if (pairZzB != null) {
                zzaazVarArr[((Integer) pairZzB.second).intValue()] = (zzaaz) pairZzB.first;
            }
        }
        if (zzA(zzaazVarArr, 3) == null) {
            int i8 = zzaamVar.zzw.zzb;
            if (!zzaamVar.zzB || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
                languageTag = null;
            } else {
                String str2 = zzfl.zza;
                languageTag = locale.toLanguageTag();
            }
            Pair pairZzB3 = zzB(3, zzabdVar, iArr, new zzaap() { // from class: com.google.android.gms.internal.ads.zzaae
                @Override // com.google.android.gms.internal.ads.zzaap
                public final /* synthetic */ List zza(int i9, zzbg zzbgVar, int[] iArr4) {
                    int i10 = zzaay.zzb;
                    int i11 = zzgwm.zzd;
                    zzgwj zzgwjVar = new zzgwj();
                    for (int i12 = 0; i12 < zzbgVar.zza; i12++) {
                        zzgwjVar.zzf(new zzaao(i9, zzbgVar, i12, zzaamVar, iArr4[i12], str, languageTag));
                    }
                    return zzgwjVar.zzi();
                }
            }, zzaaa.zza);
            if (pairZzB3 != null) {
                zzaazVarArr[((Integer) pairZzB3.second).intValue()] = (zzaaz) pairZzB3.first;
            }
        }
        int i9 = zzaamVar.zzw.zzb;
        zzgwv zzgwvVar = new zzgwv();
        int i10 = 0;
        while (i10 < 2) {
            zzaaz zzaazVar = zzaazVarArr[i10];
            if (zzaazVar == null || zzaamVar.zza(i10)) {
                i4 = i5;
            } else {
                zzgww zzgwwVar = zzaamVar.zzI;
                zzbg zzbgVar = zzaazVar.zza;
                i4 = i5;
                if (!zzgwwVar.contains(Integer.valueOf(zzbgVar.zzc))) {
                    zzgwvVar.zzf(zzbgVar.zzb);
                    int i11 = i4;
                    while (true) {
                        int[] iArr4 = zzaazVar.zzb;
                        if (i11 < iArr4.length) {
                            String str3 = zzbgVar.zza(iArr4[i11]).zzn;
                            if (str3 != null) {
                                zzgwvVar.zzf(str3);
                            }
                            i11++;
                        }
                    }
                }
            }
            i10++;
            i5 = i4;
        }
        int i12 = i5;
        zzgww zzgwwVarZzh = zzgwvVar.zzh();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i13 = i12; i13 < 2; i13++) {
            if (zzabdVar.zza(i13) == 5) {
                zzzn zzznVarZzb = zzabdVar.zzb(i13);
                for (int i14 = i12; i14 < zzznVarZzb.zzb; i14++) {
                    zzbg zzbgVarZza = zzznVarZzb.zza(i14);
                    arrayList.add(zzbgVarZza);
                    int[] iArr5 = (int[]) iArr[i13][i14].clone();
                    for (int i15 = i12; i15 < iArr5.length; i15++) {
                        String str4 = zzbgVarZza.zza(i15).zzn;
                        if (str4 != null && !zzgwwVarZzh.contains(str4)) {
                            iArr5[i15] = 128;
                        }
                    }
                    arrayList2.add(iArr5);
                }
            }
        }
        int i16 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        zzbg[] zzbgVarArr = new zzbg[arrayList.size()];
        zzfl.zzc(arrayList, zzbgVarArr);
        zzzn zzznVar = new zzzn(zzbgVarArr);
        int[][] iArr6 = new int[arrayList2.size()][];
        zzfl.zzc(arrayList2, iArr6);
        int i17 = i12;
        while (i17 < 2) {
            if (zzabdVar.zza(i17) == 5) {
                zzaaz zzaazVarZzp = zzp(5, zzznVar, iArr6, zzaamVar);
                zzaazVarArr[i17] = zzaazVarZzp;
                if (zzaazVarZzp == null) {
                    break;
                }
                i3 = i16;
                Arrays.fill(iArr6[zzznVar.zzb(zzaazVarZzp.zza)], i3);
            } else {
                i3 = i16;
            }
            i17++;
            i16 = i3;
        }
        for (int i18 = i12; i18 < 2; i18++) {
            int iZza = zzabdVar.zza(i18);
            if (iZza != 2 && iZza != 1) {
                if (iZza != 3 && iZza != 4 && iZza != 5 && zzaazVarArr[i18] == null) {
                    zzaazVarArr[i18] = zzp(iZza, zzabdVar.zzb(i18), iArr[i18], zzaamVar);
                }
            }
        }
        zzw(zzabdVar, zzaamVar, zzaazVarArr);
        zzy(zzabdVar, zzaamVar, zzaazVarArr);
        zzz(zzabdVar, zzaamVar, zzaazVarArr);
        zzzt zzztVar2 = this.zzj;
        zzabq zzabqVarZzu = zzu();
        zzgwm zzgwmVarZzd = zzzu.zzd(zzaazVarArr);
        zzaba[] zzabaVarArr = new zzaba[2];
        int i19 = i12;
        while (i19 < 2) {
            zzaaz zzaazVar2 = zzaazVarArr[i19];
            if (zzaazVar2 == null || (length = (iArr3 = zzaazVar2.zzb).length) == 0) {
                zzztVar = zzztVar2;
            } else {
                if (length == 1) {
                    zzabaVarZza = new zzabb(zzaazVar2.zza, iArr3[i12], 0, 0, null);
                    zzztVar = zzztVar2;
                } else {
                    zzztVar = zzztVar2;
                    zzabaVarZza = zzztVar.zza(zzaazVar2.zza, iArr3, 0, zzabqVarZzu, (zzgwm) zzgwmVarZzd.get(i19));
                }
                zzabaVarArr[i19] = zzabaVarZza;
            }
            i19++;
            zzztVar2 = zzztVar;
        }
        zznd[] zzndVarArr = new zznd[2];
        for (int i20 = i12; i20 < 2; i20++) {
            zzndVarArr[i20] = (zzaamVar.zza(i20) || zzaamVar.zzI.contains(Integer.valueOf(zzabdVar.zza(i20))) || (zzabdVar.zza(i20) != -2 && zzabaVarArr[i20] == null)) ? null : zznd.zza;
        }
        return Pair.create(zzndVarArr, zzabaVarArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ boolean zzl(com.google.android.gms.internal.ads.zzaam r4, com.google.android.gms.internal.ads.zzv r5) {
        /*
            r3 = this;
            boolean r4 = r4.zzU
            r0 = 1
            if (r4 == 0) goto L83
            java.lang.Boolean r4 = r3.zzi
            if (r4 == 0) goto L11
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L10
            goto L11
        L10:
            return r0
        L11:
            int r4 = r5.zzH
            r1 = -1
            if (r4 == r1) goto L83
            r1 = 2
            if (r4 <= r1) goto L83
            java.lang.String r4 = r5.zzp
            r1 = 32
            if (r4 != 0) goto L20
            goto L5a
        L20:
            int r2 = r4.hashCode()
            switch(r2) {
                case -2123537834: goto L43;
                case 187078296: goto L3a;
                case 187078297: goto L31;
                case 1504578661: goto L28;
                default: goto L27;
            }
        L27:
            goto L5a
        L28:
            java.lang.String r2 = "audio/eac3"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            goto L4b
        L31:
            java.lang.String r2 = "audio/ac4"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            goto L4b
        L3a:
            java.lang.String r2 = "audio/ac3"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            goto L4b
        L43:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
        L4b:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r1) goto L59
            com.google.android.gms.internal.ads.zzacm r4 = r3.zzg
            if (r4 == 0) goto L59
            boolean r4 = r4.zzb()
            if (r4 != 0) goto L5a
        L59:
            return r0
        L5a:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            if (r4 < r1) goto L82
            com.google.android.gms.internal.ads.zzacm r4 = r3.zzg
            if (r4 == 0) goto L82
            boolean r1 = r4.zzb()
            if (r1 == 0) goto L82
            boolean r4 = r4.zzc()
            if (r4 == 0) goto L82
            com.google.android.gms.internal.ads.zzacm r4 = r3.zzg
            boolean r4 = r4.zzd()
            if (r4 == 0) goto L82
            com.google.android.gms.internal.ads.zzacm r4 = r3.zzg
            com.google.android.gms.internal.ads.zzd r1 = r3.zzh
            boolean r4 = r4.zze(r1, r5)
            if (r4 == 0) goto L82
            return r0
        L82:
            return r2
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaay.zzl(com.google.android.gms.internal.ads.zzaam, com.google.android.gms.internal.ads.zzv):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final zznb zzg() {
        return this;
    }
}
