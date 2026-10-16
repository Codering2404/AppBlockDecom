package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg K;
    private long A;
    private final Map B;
    private final Map C;
    private final Map D;
    private zzlu F;
    private String G;
    private zzay H;
    private long I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzht f74432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgz f74433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzav f74434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzhb f74435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzok f74436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzad f74437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzpk f74438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzlp f74439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zznn f74440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzou f74441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzhk f74442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzic f74443l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f74445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    long f74446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List f74447p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f74449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f74450s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f74451t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f74452u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f74453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FileLock f74454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FileChannel f74455x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List f74456y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List f74457z;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f74444m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Deque f74448q = new LinkedList();
    private final Map E = new HashMap();
    private final zzpo J = new zzpb(this);

    zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.m(zzphVar);
        this.f74443l = zzic.O(zzphVar.f74458a, null, null);
        this.A = -1L;
        this.f74441j = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.k();
        this.f74438g = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.k();
        this.f74433b = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.k();
        this.f74432a = zzhtVar;
        this.B = new HashMap();
        this.C = new HashMap();
        this.D = new HashMap();
        b().t(new zzov(this, zzphVar));
    }

    public static zzpg F(Context context) {
        Preconditions.m(context);
        Preconditions.m(context.getApplicationContext());
        if (K == null) {
            synchronized (zzpg.class) {
                try {
                    if (K == null) {
                        K = new zzpg((zzph) Preconditions.m(new zzph(context)), null);
                    }
                } finally {
                }
            }
        }
        return K;
    }

    static final void G(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i3, String str) {
        List listZza = zzhrVar.zza();
        for (int i4 = 0; i4 < listZza.size(); i4++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i4)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb("_err");
        zzhvVarZzn.zzf(i3);
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc();
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn2.zzb("_ev");
        zzhvVarZzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    static final void H(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List listZza = zzhrVar.zza();
        for (int i3 = 0; i3 < listZza.size(); i3++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzb())) {
                zzhrVar.zzj(i3);
                return;
            }
        }
    }

    private final int I(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzjiVarM;
        zzht zzhtVar = this.f74432a;
        if (zzhtVar.R(str) == null) {
            zzanVar.c(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzhVarJ0 = F0().J0(str);
        if (zzhVarJ0 != null && zze.c(zzhVarJ0.I()).a() == zzji.POLICY && (zzjiVarM = zzhtVar.m(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.c(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzjiVarM == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.c(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.P(str, zzjkVar2) ? 0 : 1;
    }

    private final Map J(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap map = new HashMap();
        K0();
        for (Map.Entry entry : zzpk.t(zzhsVar, "gad_").entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    private final zzay K() {
        if (this.H == null) {
            this.H = new zzoy(this, this.f74443l);
        }
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final void v0() {
        b().h();
        if (this.f74448q.isEmpty() || K().c()) {
            return;
        }
        long jMax = Math.max(0L, ((long) ((Integer) zzfy.C0.b(null)).intValue()) - (e().a() - this.I));
        a().w().b("Scheduling notify next app runnable, delay in ms", Long.valueOf(jMax));
        K().b(jMax);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:8|(5:9|10|(4:12|13|(4:15|(1:22)|25|487)(18:26|27|(2:35|(3:37|(1:44)(1:43)|45)(0))(1:34)|46|(2:48|(3:50|(4:53|(1:492)(2:59|489)|60|51)|488))|61|62|(5:64|65|(3:68|(0)|(7:117|(5:121|(2:123|503)(2:124|(2:126|502)(1:504))|127|118|119)|501|128|(2:131|(3:137|(1:139)(2:140|(3:142|(3:145|(1:147)(1:520)|143)|519))|148)(2:135|136))(1:130)|149|(2:151|(6:(2:156|(6:158|159|193|(9:195|(4:198|(2:211|(2:213|506)(1:508))(5:202|(5:205|(2:208|206)|510|209|203)|509|210|507)|214|196)|505|215|(4:218|(3:512|220|515)(1:514)|513|216)|511|221|(1:223)|516)(1:224)|225|486))|160|193|(0)(0)|225|486)(7:161|162|192|193|(0)(0)|225|486))(2:163|(8:165|(6:(2:170|(6:172|159|193|(0)(0)|225|486))|173|193|(0)(0)|225|486)|162|192|193|(0)(0)|225|486)(7:174|(2:185|(2:186|(2:188|(2:518|190)(1:191))(1:517)))(0)|192|193|(0)(0)|225|486)))(3:136|149|(0)(0)))|71|(0)(0))(1:72)|70|(3:73|74|(3:76|(2:78|495)(2:79|(2:81|494)(1:496))|82)(1:493))|83|(1:87)(1:86)|(1:89)|90|(1:92)(1:93)|94|(2:97|(4:99|(4:102|(2:104|499)(2:105|(2:107|498)(1:500))|108|100)|497|(1:(1:114)(1:115))(1:(1:111)(2:112|(0)(0)))))|(0)(0))|226)(1:485)|474|475)|227|(3:229|(2:231|(2:233|523)(2:234|(1:524)(3:236|(1:238)(1:239)|(1:526)(2:243|522))))(0)|244)|521|245|(3:246|247|(1:527)(2:249|(2:528|251)(1:529)))|252|(1:254)(2:255|(1:257))|258|(1:260)(1:261)|262|(1:264)(1:265)|266|(6:269|(1:271)|272|(2:274|531)(1:532)|275|267)|530|276|(2:281|(1:285))(1:280)|286|(1:288)|289|(1:291)|292|(1:300)|301|(10:483|303|(7:306|307|(5:309|(1:313)|(1:330)(5:317|(1:321)|323|(1:328)(1:327)|329)|331|332)(7:334|335|(6:481|337|338|343|(6:345|(3:348|(3:541|350|(3:352|358|(1:360)(7:361|(6:363|(1:365)|368|(1:370)(1:372)|371|(4:374|(1:382)|383|539)(4:384|(3:386|(1:388)|389)(5:390|(1:392)(1:393)|394|(3:396|(1:398)|399)(2:401|(1:403))|400)|404|537))(1:367)|366|368|(0)(0)|371|(0)(0)))(2:353|(0)(0)))(1:356)|346)|540|357|358|(0)(0))(3:357|358|(0)(0))|405)(1:342)|341|343|(0)(0)|405)|333|538|405|304)|536|406|(1:408)|409|(2:412|410)|542|413)(1:414)|415|(1:417)(13:419|(9:421|(1:423)(1:424)|425|(1:427)(1:428)|429|(1:431)(1:432)|433|(1:435)(1:436)|437)|438|(4:440|441|(2:449|(1:451)(1:452))(1:446)|453)(1:454)|455|(3:(2:459|534)(1:535)|460|456)|533|461|(1:463)|464|477|465|469)|418|438|(0)(0)|455|(1:456)|533|461|(0)|464|477|465|469) */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0dd9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x0dda, code lost:
    
        r3.f73997a.a().o().c("Failed to remove unused event metadata. appId", com.google.android.gms.measurement.internal.zzgu.x(r1), r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03bd A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03d5 A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03ee A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04b1 A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04fc A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05b1 A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0708 A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:3:0x0017, B:5:0x002e, B:8:0x0038, B:9:0x004e, B:12:0x0060, B:15:0x008a, B:17:0x00bf, B:20:0x00d0, B:22:0x00da, B:226:0x06cf, B:26:0x0107, B:29:0x0119, B:31:0x011f, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:60:0x01d2, B:61:0x01d5, B:64:0x01eb, B:73:0x021e, B:76:0x0228, B:78:0x0236, B:82:0x027d, B:79:0x0253, B:81:0x0263, B:86:0x028a, B:89:0x02bf, B:90:0x02e9, B:92:0x0322, B:94:0x0328, B:97:0x0334, B:99:0x036b, B:100:0x0386, B:102:0x038c, B:104:0x039a, B:108:0x03af, B:105:0x03a3, B:111:0x03b6, B:114:0x03bd, B:115:0x03d5, B:117:0x03ee, B:118:0x03fa, B:121:0x0404, B:127:0x0427, B:124:0x0416, B:149:0x04a5, B:151:0x04b1, B:154:0x04c2, B:156:0x04d3, B:158:0x04df, B:193:0x05ab, B:195:0x05b1, B:196:0x05bd, B:198:0x05c3, B:200:0x05d3, B:202:0x05dd, B:203:0x05ee, B:205:0x05f4, B:206:0x060f, B:208:0x0615, B:209:0x0633, B:210:0x0640, B:214:0x0665, B:211:0x0646, B:213:0x0652, B:215:0x066c, B:216:0x0682, B:218:0x0688, B:220:0x069b, B:221:0x06a8, B:223:0x06af, B:225:0x06bd, B:163:0x04fc, B:165:0x050a, B:168:0x051d, B:170:0x052f, B:172:0x053b, B:174:0x054b, B:176:0x055a, B:179:0x0566, B:181:0x0570, B:183:0x057a, B:186:0x0585, B:188:0x058b, B:190:0x059b, B:191:0x05a6, B:131:0x042f, B:133:0x043b, B:135:0x0447, B:148:0x048d, B:140:0x0465, B:143:0x0477, B:145:0x047d, B:147:0x0487, B:35:0x012b, B:37:0x0138, B:39:0x0144, B:41:0x014a, B:45:0x0155, B:229:0x06e9, B:231:0x06f7, B:233:0x0700, B:244:0x0730, B:234:0x0708, B:236:0x0711, B:238:0x0717, B:241:0x0723, B:243:0x072b, B:245:0x0733, B:246:0x073f, B:249:0x0747, B:251:0x0759, B:252:0x0764, B:254:0x076c, B:258:0x0792, B:260:0x07ac, B:262:0x07c1, B:264:0x07db, B:266:0x07f0, B:267:0x07fe, B:269:0x0804, B:271:0x0814, B:272:0x081b, B:274:0x0827, B:275:0x082e, B:276:0x0831, B:278:0x0873, B:280:0x0879, B:286:0x08a0, B:288:0x08a8, B:289:0x08b1, B:291:0x08b7, B:292:0x08bd, B:294:0x08d2, B:296:0x08e2, B:298:0x08f2, B:300:0x08fa, B:301:0x08fd, B:309:0x0973, B:311:0x098c, B:313:0x09a2, B:315:0x09a7, B:317:0x09ab, B:319:0x09af, B:321:0x09b9, B:323:0x09c2, B:325:0x09c6, B:327:0x09cc, B:329:0x09d7, B:331:0x09e5, B:337:0x0a0d, B:340:0x0a15, B:281:0x0887, B:283:0x088d, B:285:0x0893, B:265:0x07ed, B:261:0x07be, B:255:0x0772, B:257:0x0778), top: B:479:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0a4a A[Catch: all -> 0x0a7b, TryCatch #4 {all -> 0x0a7b, blocks: (B:303:0x093f, B:304:0x0952, B:306:0x0958, B:405:0x0c1b, B:335:0x09f7, B:343:0x0a30, B:345:0x0a4a, B:346:0x0a52, B:348:0x0a58, B:350:0x0a6a, B:358:0x0a85, B:360:0x0a99, B:361:0x0abc, B:363:0x0ac8, B:365:0x0ade, B:368:0x0b23, B:374:0x0b3f, B:376:0x0b4a, B:378:0x0b4e, B:380:0x0b52, B:382:0x0b56, B:383:0x0b62, B:384:0x0b6e, B:386:0x0b74, B:388:0x0b8a, B:389:0x0b8f, B:404:0x0c18, B:390:0x0ba7, B:392:0x0bab, B:396:0x0bce, B:398:0x0bee, B:399:0x0bf5, B:403:0x0c0b, B:393:0x0bb6, B:406:0x0c29, B:408:0x0c38, B:409:0x0c3e, B:410:0x0c46, B:412:0x0c4c, B:415:0x0c66, B:417:0x0c76, B:438:0x0cf4, B:419:0x0c8f, B:421:0x0c95, B:423:0x0c9d, B:425:0x0ca4, B:431:0x0cb2, B:433:0x0cb9, B:435:0x0ce5, B:437:0x0cec, B:436:0x0ce9, B:432:0x0cb6, B:424:0x0ca1), top: B:483:0x093f }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0a83 A[PHI: r10
      0x0a83: PHI (r10v7 java.lang.String) = (r10v6 java.lang.String), (r10v22 java.lang.String) binds: [B:344:0x0a48, B:540:0x0a83] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0a99 A[Catch: all -> 0x0a7b, TryCatch #4 {all -> 0x0a7b, blocks: (B:303:0x093f, B:304:0x0952, B:306:0x0958, B:405:0x0c1b, B:335:0x09f7, B:343:0x0a30, B:345:0x0a4a, B:346:0x0a52, B:348:0x0a58, B:350:0x0a6a, B:358:0x0a85, B:360:0x0a99, B:361:0x0abc, B:363:0x0ac8, B:365:0x0ade, B:368:0x0b23, B:374:0x0b3f, B:376:0x0b4a, B:378:0x0b4e, B:380:0x0b52, B:382:0x0b56, B:383:0x0b62, B:384:0x0b6e, B:386:0x0b74, B:388:0x0b8a, B:389:0x0b8f, B:404:0x0c18, B:390:0x0ba7, B:392:0x0bab, B:396:0x0bce, B:398:0x0bee, B:399:0x0bf5, B:403:0x0c0b, B:393:0x0bb6, B:406:0x0c29, B:408:0x0c38, B:409:0x0c3e, B:410:0x0c46, B:412:0x0c4c, B:415:0x0c66, B:417:0x0c76, B:438:0x0cf4, B:419:0x0c8f, B:421:0x0c95, B:423:0x0c9d, B:425:0x0ca4, B:431:0x0cb2, B:433:0x0cb9, B:435:0x0ce5, B:437:0x0cec, B:436:0x0ce9, B:432:0x0cb6, B:424:0x0ca1), top: B:483:0x093f }] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0abc A[Catch: all -> 0x0a7b, TryCatch #4 {all -> 0x0a7b, blocks: (B:303:0x093f, B:304:0x0952, B:306:0x0958, B:405:0x0c1b, B:335:0x09f7, B:343:0x0a30, B:345:0x0a4a, B:346:0x0a52, B:348:0x0a58, B:350:0x0a6a, B:358:0x0a85, B:360:0x0a99, B:361:0x0abc, B:363:0x0ac8, B:365:0x0ade, B:368:0x0b23, B:374:0x0b3f, B:376:0x0b4a, B:378:0x0b4e, B:380:0x0b52, B:382:0x0b56, B:383:0x0b62, B:384:0x0b6e, B:386:0x0b74, B:388:0x0b8a, B:389:0x0b8f, B:404:0x0c18, B:390:0x0ba7, B:392:0x0bab, B:396:0x0bce, B:398:0x0bee, B:399:0x0bf5, B:403:0x0c0b, B:393:0x0bb6, B:406:0x0c29, B:408:0x0c38, B:409:0x0c3e, B:410:0x0c46, B:412:0x0c4c, B:415:0x0c66, B:417:0x0c76, B:438:0x0cf4, B:419:0x0c8f, B:421:0x0c95, B:423:0x0c9d, B:425:0x0ca4, B:431:0x0cb2, B:433:0x0cb9, B:435:0x0ce5, B:437:0x0cec, B:436:0x0ce9, B:432:0x0cb6, B:424:0x0ca1), top: B:483:0x093f }] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0b36  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0b3a  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0b3f A[Catch: all -> 0x0a7b, TryCatch #4 {all -> 0x0a7b, blocks: (B:303:0x093f, B:304:0x0952, B:306:0x0958, B:405:0x0c1b, B:335:0x09f7, B:343:0x0a30, B:345:0x0a4a, B:346:0x0a52, B:348:0x0a58, B:350:0x0a6a, B:358:0x0a85, B:360:0x0a99, B:361:0x0abc, B:363:0x0ac8, B:365:0x0ade, B:368:0x0b23, B:374:0x0b3f, B:376:0x0b4a, B:378:0x0b4e, B:380:0x0b52, B:382:0x0b56, B:383:0x0b62, B:384:0x0b6e, B:386:0x0b74, B:388:0x0b8a, B:389:0x0b8f, B:404:0x0c18, B:390:0x0ba7, B:392:0x0bab, B:396:0x0bce, B:398:0x0bee, B:399:0x0bf5, B:403:0x0c0b, B:393:0x0bb6, B:406:0x0c29, B:408:0x0c38, B:409:0x0c3e, B:410:0x0c46, B:412:0x0c4c, B:415:0x0c66, B:417:0x0c76, B:438:0x0cf4, B:419:0x0c8f, B:421:0x0c95, B:423:0x0c9d, B:425:0x0ca4, B:431:0x0cb2, B:433:0x0cb9, B:435:0x0ce5, B:437:0x0cec, B:436:0x0ce9, B:432:0x0cb6, B:424:0x0ca1), top: B:483:0x093f }] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0b6e A[Catch: all -> 0x0a7b, TryCatch #4 {all -> 0x0a7b, blocks: (B:303:0x093f, B:304:0x0952, B:306:0x0958, B:405:0x0c1b, B:335:0x09f7, B:343:0x0a30, B:345:0x0a4a, B:346:0x0a52, B:348:0x0a58, B:350:0x0a6a, B:358:0x0a85, B:360:0x0a99, B:361:0x0abc, B:363:0x0ac8, B:365:0x0ade, B:368:0x0b23, B:374:0x0b3f, B:376:0x0b4a, B:378:0x0b4e, B:380:0x0b52, B:382:0x0b56, B:383:0x0b62, B:384:0x0b6e, B:386:0x0b74, B:388:0x0b8a, B:389:0x0b8f, B:404:0x0c18, B:390:0x0ba7, B:392:0x0bab, B:396:0x0bce, B:398:0x0bee, B:399:0x0bf5, B:403:0x0c0b, B:393:0x0bb6, B:406:0x0c29, B:408:0x0c38, B:409:0x0c3e, B:410:0x0c46, B:412:0x0c4c, B:415:0x0c66, B:417:0x0c76, B:438:0x0cf4, B:419:0x0c8f, B:421:0x0c95, B:423:0x0c9d, B:425:0x0ca4, B:431:0x0cb2, B:433:0x0cb9, B:435:0x0ce5, B:437:0x0cec, B:436:0x0ce9, B:432:0x0cb6, B:424:0x0ca1), top: B:483:0x093f }] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0cfa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0d5c  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0d7b  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0dac A[Catch: all -> 0x0d20, TryCatch #0 {all -> 0x0d20, blocks: (B:441:0x0cfc, B:443:0x0d11, B:446:0x0d18, B:453:0x0d4c, B:455:0x0d5e, B:456:0x0d75, B:459:0x0d7d, B:460:0x0d82, B:461:0x0d92, B:463:0x0dac, B:464:0x0dc7, B:465:0x0dcf, B:469:0x0ded, B:468:0x0dda, B:449:0x0d23, B:451:0x0d2f, B:452:0x0d35, B:470:0x0df6), top: B:476:0x002c, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r11v14, types: [com.google.android.gms.internal.measurement.zzhr, com.google.android.gms.internal.measurement.zzmb] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [com.google.android.gms.internal.measurement.zzhr, com.google.android.gms.internal.measurement.zzmb] */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v17 */
    /* JADX WARN: Type inference failed for: r17v18 */
    /* JADX WARN: Type inference failed for: r17v19 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v22 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [com.google.android.gms.internal.measurement.zzhr, com.google.android.gms.internal.measurement.zzmb] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v11 */
    /* JADX WARN: Type inference failed for: r21v12 */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v21 */
    /* JADX WARN: Type inference failed for: r21v22 */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r28v10 */
    /* JADX WARN: Type inference failed for: r28v14 */
    /* JADX WARN: Type inference failed for: r28v15 */
    /* JADX WARN: Type inference failed for: r28v16 */
    /* JADX WARN: Type inference failed for: r28v17 */
    /* JADX WARN: Type inference failed for: r28v18 */
    /* JADX WARN: Type inference failed for: r28v19 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v20 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v115 */
    /* JADX WARN: Type inference failed for: r2v116 */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v118 */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v17, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v46 */
    /* JADX WARN: Type inference failed for: r9v47 */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.google.android.gms.internal.measurement.zzic, com.google.android.gms.internal.measurement.zzmb] */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean M(java.lang.String r44, long r45) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.M(java.lang.String, long):boolean");
    }

    private final void N(com.google.android.gms.internal.measurement.zzic zzicVar, long j3, boolean z2) {
        Object obj;
        String str = true != z2 ? "_lte" : "_se";
        zzpn zzpnVarB0 = F0().B0(zzicVar.zzK(), str);
        zzpn zzpnVar = (zzpnVarB0 == null || (obj = zzpnVarB0.f74488e) == null) ? new zzpn(zzicVar.zzK(), "auto", str, e().currentTimeMillis(), Long.valueOf(j3)) : new zzpn(zzicVar.zzK(), "auto", str, e().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j3));
        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
        zzitVarZzm.zzb(str);
        zzitVarZzm.zza(e().currentTimeMillis());
        Object obj2 = zzpnVar.f74488e;
        zzitVarZzm.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbc();
        int iX = zzpk.X(zzicVar, str);
        if (iX >= 0) {
            zzicVar.zzn(iX, zziuVar);
        } else {
            zzicVar.zzo(zziuVar);
        }
        if (j3 > 0) {
            F0().A0(zzpnVar);
            a().w().c("Updated engagement user property. scope, value", true != z2 ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean O(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.a("_e".equals(zzhrVar.zzk()));
        K0();
        com.google.android.gms.internal.measurement.zzhw zzhwVarR = zzpk.r((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_sc");
        String strZzd = zzhwVarR == null ? null : zzhwVarR.zzd();
        K0();
        com.google.android.gms.internal.measurement.zzhw zzhwVarR2 = zzpk.r((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_pc");
        String strZzd2 = zzhwVarR2 != null ? zzhwVarR2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        Preconditions.a("_e".equals(zzhrVar.zzk()));
        K0();
        com.google.android.gms.internal.measurement.zzhw zzhwVarR3 = zzpk.r((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_et");
        if (zzhwVarR3 == null || !zzhwVarR3.zze() || zzhwVarR3.zzf() <= 0) {
            return true;
        }
        long jZzf = zzhwVarR3.zzf();
        K0();
        com.google.android.gms.internal.measurement.zzhw zzhwVarR4 = zzpk.r((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_et");
        if (zzhwVarR4 != null && zzhwVarR4.zzf() > 0) {
            jZzf += zzhwVarR4.zzf();
        }
        K0();
        zzpk.o(zzhrVar2, "_et", Long.valueOf(jZzf));
        K0();
        zzpk.o(zzhrVar, "_fr", 1L);
        return true;
    }

    private final boolean P() {
        b().h();
        O0();
        return F0().B() || !TextUtils.isEmpty(F0().r());
    }

    private static String Q(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private final void R() {
        long jMax;
        long jMax2;
        b().h();
        O0();
        if (this.f74446o > 0) {
            long jAbs = 3600000 - Math.abs(e().a() - this.f74446o);
            if (jAbs > 0) {
                a().w().b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                G0().b();
                H0().n();
                return;
            }
            this.f74446o = 0L;
        }
        if (!this.f74443l.m() || !P()) {
            a().w().a("Nothing to upload or uploading impossible");
            G0().b();
            H0().n();
            return;
        }
        long jCurrentTimeMillis = e().currentTimeMillis();
        B0();
        long jMax3 = Math.max(0L, ((Long) zzfy.P.b(null)).longValue());
        boolean z2 = true;
        if (!F0().D() && !F0().s()) {
            z2 = false;
        }
        if (z2) {
            String strI = B0().i();
            if (TextUtils.isEmpty(strI) || ".none.".equals(strI)) {
                B0();
                jMax = Math.max(0L, ((Long) zzfy.J.b(null)).longValue());
            } else {
                B0();
                jMax = Math.max(0L, ((Long) zzfy.K.b(null)).longValue());
            }
        } else {
            B0();
            jMax = Math.max(0L, ((Long) zzfy.I.b(null)).longValue());
        }
        long jA = this.f74440i.f74334h.a();
        long jA2 = this.f74440i.f74335i.a();
        long j3 = 0;
        boolean z3 = z2;
        long jMax4 = Math.max(F0().y(), F0().A());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jA - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jA2 - jCurrentTimeMillis);
            jMax2 = jMax3 + jAbs2;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z3 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            if (!K0().S(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i3 = 0;
                while (true) {
                    B0();
                    if (i3 >= Math.min(20, Math.max(0, ((Integer) zzfy.R.b(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    B0();
                    jMax2 += Math.max(j3, ((Long) zzfy.Q.b(null)).longValue()) * (1 << i3);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                    i3++;
                    j3 = 0;
                }
            }
            j3 = 0;
        }
        if (jMax2 == j3) {
            a().w().a("Next upload time is 0");
            G0().b();
            H0().n();
            return;
        }
        if (!E0().m()) {
            a().w().a("No network");
            G0().a();
            H0().n();
            return;
        }
        long jA3 = this.f74440i.f74333g.a();
        B0();
        long jMax6 = Math.max(0L, ((Long) zzfy.G.b(null)).longValue());
        if (!K0().S(jA3, jMax6)) {
            jMax2 = Math.max(jMax2, jA3 + jMax6);
        }
        G0().b();
        long jCurrentTimeMillis2 = jMax2 - e().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            B0();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzfy.L.b(null)).longValue());
            this.f74440i.f74334h.b(e().currentTimeMillis());
        }
        a().w().b("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        H0().m(jCurrentTimeMillis2);
    }

    private final void S() {
        b().h();
        if (this.f74451t || this.f74452u || this.f74453v) {
            a().w().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f74451t), Boolean.valueOf(this.f74452u), Boolean.valueOf(this.f74453v));
            return;
        }
        a().w().a("Stopping uploading service(s)");
        List list = this.f74447p;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.m(this.f74447p)).clear();
    }

    private final Boolean T(zzh zzhVar) {
        try {
            if (zzhVar.F0() != -2147483648L) {
                if (zzhVar.F0() == Wrappers.a(this.f74443l.d()).f(zzhVar.o0(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.a(this.f74443l.d()).f(zzhVar.o0(), 0).versionName;
                String strD0 = zzhVar.D0();
                if (strD0 != null && strD0.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr U(String str) {
        zzh zzhVarJ0 = F0().J0(str);
        if (zzhVarJ0 == null || TextUtils.isEmpty(zzhVarJ0.D0())) {
            a().v().b("No app data available; dropping", str);
            return null;
        }
        Boolean boolT = T(zzhVarJ0);
        if (boolT == null || boolT.booleanValue()) {
            return new zzr(str, zzhVarJ0.r0(), zzhVarJ0.D0(), zzhVarJ0.F0(), zzhVarJ0.H0(), zzhVarJ0.J0(), zzhVarJ0.L0(), (String) null, zzhVarJ0.d(), false, zzhVarJ0.x0(), 0L, 0, zzhVarJ0.P(), false, zzhVarJ0.R(), zzhVarJ0.b(), zzhVarJ0.T(), g(str).l(), "", (String) null, zzhVarJ0.V(), zzhVarJ0.X(), g(str).b(), R0(str).e(), zzhVarJ0.b0(), zzhVarJ0.j0(), zzhVarJ0.l0(), zzhVarJ0.I(), 0L, zzhVarJ0.M());
        }
        a().o().b("App version does not match; dropping. appId", zzgu.x(str));
        return null;
    }

    private final boolean V(String str, String str2) {
        zzbc zzbcVarV0 = F0().v0(str, str2);
        return zzbcVarV0 == null || zzbcVarV0.f73472c < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean X(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.f74501b);
    }

    private static final zzos Y(zzos zzosVar) {
        if (zzosVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzosVar.i()) {
            return zzosVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzosVar.getClass())));
    }

    private static final Boolean Z(zzr zzrVar) {
        Boolean bool = zzrVar.f74515q;
        String str = zzrVar.D;
        if (!TextUtils.isEmpty(str)) {
            zzji zzjiVarA = zze.c(str).a();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int iOrdinal = zzjiVarA.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return Boolean.TRUE;
            }
            if (iOrdinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[Catch: all -> 0x0016, TryCatch #2 {all -> 0x0016, blocks: (B:4:0x0013, B:8:0x001b, B:16:0x0034, B:21:0x0080, B:20:0x0071, B:22:0x008c, B:24:0x00a3, B:27:0x00b6, B:29:0x00c4, B:31:0x00e4, B:73:0x021f, B:75:0x0232, B:77:0x023c, B:85:0x025c, B:79:0x0242, B:81:0x024c, B:83:0x0252, B:84:0x0256, B:86:0x025f, B:87:0x0266, B:30:0x00d7, B:88:0x0267), top: B:95:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c A[Catch: all -> 0x0016, PHI: r0
      0x008c: PHI (r0v2 int) = (r0v0 int), (r0v37 int) binds: [B:9:0x0027, B:15:0x0032] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x0016, blocks: (B:4:0x0013, B:8:0x001b, B:16:0x0034, B:21:0x0080, B:20:0x0071, B:22:0x008c, B:24:0x00a3, B:27:0x00b6, B:29:0x00c4, B:31:0x00e4, B:73:0x021f, B:75:0x0232, B:77:0x023c, B:85:0x025c, B:79:0x0242, B:81:0x024c, B:83:0x0252, B:84:0x0256, B:86:0x025f, B:87:0x0266, B:30:0x00d7, B:88:0x0267), top: B:95:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4 A[Catch: all -> 0x0016, SQLiteException -> 0x00b3, TryCatch #1 {SQLiteException -> 0x00b3, blocks: (B:24:0x00a3, B:27:0x00b6, B:29:0x00c4, B:31:0x00e4, B:73:0x021f, B:75:0x0232, B:77:0x023c, B:85:0x025c, B:79:0x0242, B:81:0x024c, B:83:0x0252, B:84:0x0256, B:86:0x025f, B:87:0x0266, B:30:0x00d7), top: B:94:0x00a3, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7 A[Catch: all -> 0x0016, SQLiteException -> 0x00b3, TryCatch #1 {SQLiteException -> 0x00b3, blocks: (B:24:0x00a3, B:27:0x00b6, B:29:0x00c4, B:31:0x00e4, B:73:0x021f, B:75:0x0232, B:77:0x023c, B:85:0x025c, B:79:0x0242, B:81:0x024c, B:83:0x0252, B:84:0x0256, B:86:0x025f, B:87:0x0266, B:30:0x00d7), top: B:94:0x00a3, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[Catch: all -> 0x0155, TryCatch #0 {all -> 0x0155, blocks: (B:32:0x00eb, B:33:0x00f4, B:35:0x00fc, B:37:0x0113, B:41:0x013d, B:43:0x0147, B:47:0x0158, B:48:0x015d, B:50:0x0163, B:52:0x017a, B:54:0x019f, B:56:0x01ba, B:58:0x01dd, B:59:0x01ee, B:60:0x01f2, B:62:0x01f8, B:63:0x01ff, B:66:0x020c, B:68:0x0210, B:71:0x0217, B:72:0x0218), top: B:93:0x00eb, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0163 A[Catch: all -> 0x0155, TryCatch #0 {all -> 0x0155, blocks: (B:32:0x00eb, B:33:0x00f4, B:35:0x00fc, B:37:0x0113, B:41:0x013d, B:43:0x0147, B:47:0x0158, B:48:0x015d, B:50:0x0163, B:52:0x017a, B:54:0x019f, B:56:0x01ba, B:58:0x01dd, B:59:0x01ee, B:60:0x01f2, B:62:0x01f8, B:63:0x01ff, B:66:0x020c, B:68:0x0210, B:71:0x0217, B:72:0x0218), top: B:93:0x00eb, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ba A[Catch: all -> 0x0155, TryCatch #0 {all -> 0x0155, blocks: (B:32:0x00eb, B:33:0x00f4, B:35:0x00fc, B:37:0x0113, B:41:0x013d, B:43:0x0147, B:47:0x0158, B:48:0x015d, B:50:0x0163, B:52:0x017a, B:54:0x019f, B:56:0x01ba, B:58:0x01dd, B:59:0x01ee, B:60:0x01f2, B:62:0x01f8, B:63:0x01ff, B:66:0x020c, B:68:0x0210, B:71:0x0217, B:72:0x0218), top: B:93:0x00eb, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f8 A[Catch: all -> 0x0155, TRY_LEAVE, TryCatch #0 {all -> 0x0155, blocks: (B:32:0x00eb, B:33:0x00f4, B:35:0x00fc, B:37:0x0113, B:41:0x013d, B:43:0x0147, B:47:0x0158, B:48:0x015d, B:50:0x0163, B:52:0x017a, B:54:0x019f, B:56:0x01ba, B:58:0x01dd, B:59:0x01ee, B:60:0x01f2, B:62:0x01f8, B:63:0x01ff, B:66:0x020c, B:68:0x0210, B:71:0x0217, B:72:0x0218), top: B:93:0x00eb, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0242 A[Catch: all -> 0x0016, SQLiteException -> 0x00b3, TryCatch #1 {SQLiteException -> 0x00b3, blocks: (B:24:0x00a3, B:27:0x00b6, B:29:0x00c4, B:31:0x00e4, B:73:0x021f, B:75:0x0232, B:77:0x023c, B:85:0x025c, B:79:0x0242, B:81:0x024c, B:83:0x0252, B:84:0x0256, B:86:0x025f, B:87:0x0266, B:30:0x00d7), top: B:94:0x00a3, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0256 A[Catch: all -> 0x0016, SQLiteException -> 0x00b3, TryCatch #1 {SQLiteException -> 0x00b3, blocks: (B:24:0x00a3, B:27:0x00b6, B:29:0x00c4, B:31:0x00e4, B:73:0x021f, B:75:0x0232, B:77:0x023c, B:85:0x025c, B:79:0x0242, B:81:0x024c, B:83:0x0252, B:84:0x0256, B:86:0x025f, B:87:0x0266, B:30:0x00d7), top: B:94:0x00a3, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void A(boolean r19, int r20, java.lang.Throwable r21, byte[] r22, java.lang.String r23, java.util.List r24) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.A(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    protected final void A0() {
        b().h();
        F0().u();
        zzav zzavVarF0 = F0();
        zzavVarF0.h();
        zzavVarF0.j();
        if (zzavVarF0.a0()) {
            zzfx zzfxVar = zzfy.f73676w0;
            if (((Long) zzfxVar.b(null)).longValue() != 0) {
                SQLiteDatabase sQLiteDatabaseU0 = zzavVarF0.u0();
                zzic zzicVar = zzavVarF0.f73997a;
                int iDelete = sQLiteDatabaseU0.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.e().currentTimeMillis()), String.valueOf(zzfxVar.b(null))});
                if (iDelete > 0) {
                    zzicVar.a().w().b("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(iDelete));
                }
            }
        }
        if (this.f74440i.f74334h.a() == 0) {
            this.f74440i.f74334h.b(e().currentTimeMillis());
        }
        R();
    }

    final void B(zzh zzhVar) {
        b().h();
        if (TextUtils.isEmpty(zzhVar.r0())) {
            C((String) Preconditions.m(zzhVar.o0()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.m(zzhVar.o0());
        a().w().b("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzglVarW = D0().w(str);
        String strY = D0().y(str);
        ArrayMap arrayMap = null;
        if (zzglVarW != null) {
            if (!TextUtils.isEmpty(strY)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", strY);
            }
            String strZ = D0().z(str);
            if (!TextUtils.isEmpty(strZ)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put("If-None-Match", strZ);
            }
        }
        this.f74451t = true;
        E0().o(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void a(String str2, int i3, Throwable th, byte[] bArr, Map map) {
                this.f74431a.C(str2, i3, th, bArr, map);
            }
        });
    }

    public final zzal B0() {
        return ((zzic) Preconditions.m(this.f74443l)).w();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void C(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.C(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final zzou C0() {
        return this.f74441j;
    }

    final void D(Runnable runnable) {
        b().h();
        if (this.f74447p == null) {
            this.f74447p = new ArrayList();
        }
        this.f74447p.add(runnable);
    }

    public final zzht D0() {
        zzht zzhtVar = this.f74432a;
        Y(zzhtVar);
        return zzhtVar;
    }

    final void E() {
        b().h();
        O0();
        if (this.f74445n) {
            return;
        }
        this.f74445n = true;
        if (a0()) {
            FileChannel fileChannel = this.f74455x;
            b().h();
            int i3 = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                a().o().a("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i4 = fileChannel.read(byteBufferAllocate);
                    if (i4 == 4) {
                        byteBufferAllocate.flip();
                        i3 = byteBufferAllocate.getInt();
                    } else if (i4 != -1) {
                        a().r().b("Unexpected data length. Bytes read", Integer.valueOf(i4));
                    }
                } catch (IOException e3) {
                    a().o().b("Failed to read from channel", e3);
                }
            }
            int iT = this.f74443l.L().t();
            b().h();
            if (i3 > iT) {
                a().o().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i3), Integer.valueOf(iT));
                return;
            }
            if (i3 < iT) {
                FileChannel fileChannel2 = this.f74455x;
                b().h();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    a().o().a("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iT);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            a().o().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        a().w().c("Storage version upgraded. Previous, current version", Integer.valueOf(i3), Integer.valueOf(iT));
                        return;
                    } catch (IOException e4) {
                        a().o().b("Failed to write to channel", e4);
                    }
                }
                a().o().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i3), Integer.valueOf(iT));
            }
        }
    }

    public final zzgz E0() {
        zzgz zzgzVar = this.f74433b;
        Y(zzgzVar);
        return zzgzVar;
    }

    public final zzav F0() {
        zzav zzavVar = this.f74434c;
        Y(zzavVar);
        return zzavVar;
    }

    public final zzhb G0() {
        zzhb zzhbVar = this.f74435d;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzok H0() {
        zzok zzokVar = this.f74436e;
        Y(zzokVar);
        return zzokVar;
    }

    public final zzad I0() {
        zzad zzadVar = this.f74437f;
        Y(zzadVar);
        return zzadVar;
    }

    public final zzlp J0() {
        zzlp zzlpVar = this.f74439h;
        Y(zzlpVar);
        return zzlpVar;
    }

    public final zzpk K0() {
        zzpk zzpkVar = this.f74438g;
        Y(zzpkVar);
        return zzpkVar;
    }

    public final zznn L0() {
        return this.f74440i;
    }

    public final zzgn M0() {
        return this.f74443l.D();
    }

    public final zzpp N0() {
        return ((zzic) Preconditions.m(this.f74443l)).C();
    }

    final void O0() {
        if (!this.f74444m.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void P0(zzr zzrVar) {
        b().h();
        O0();
        String str = zzrVar.f74500a;
        Preconditions.g(str);
        zzjl zzjlVarF = zzjl.f(zzrVar.f74518t, zzrVar.f74523y);
        g(str);
        a().w().c("Setting storage consent for package", str, zzjlVarF);
        f(str, zzjlVarF);
    }

    final zzaz R0(String str) {
        b().h();
        O0();
        Map map = this.C;
        zzaz zzazVar = (zzaz) map.get(str);
        if (zzazVar != null) {
            return zzazVar;
        }
        zzaz zzazVarU = F0().U(str);
        map.put(str, zzazVarU);
        return zzazVarU;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.gms.measurement.internal.zzaz T0(java.lang.String r10, com.google.android.gms.measurement.internal.zzaz r11, com.google.android.gms.measurement.internal.zzjl r12, com.google.android.gms.measurement.internal.zzan r13) {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzht r0 = r9.D0()
            com.google.android.gms.internal.measurement.zzgf r0 = r0.R(r10)
            java.lang.String r1 = "-"
            r2 = 90
            if (r0 != 0) goto L31
            com.google.android.gms.measurement.internal.zzji r10 = r11.c()
            com.google.android.gms.measurement.internal.zzji r12 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r10 != r12) goto L20
            int r2 = r11.b()
            com.google.android.gms.measurement.internal.zzjk r10 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            r13.b(r10, r2)
            goto L27
        L20:
            com.google.android.gms.measurement.internal.zzjk r10 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzam r11 = com.google.android.gms.measurement.internal.zzam.FAILSAFE
            r13.c(r10, r11)
        L27:
            com.google.android.gms.measurement.internal.zzaz r10 = new com.google.android.gms.measurement.internal.zzaz
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r10.<init>(r11, r2, r12, r1)
            return r10
        L31:
            com.google.android.gms.measurement.internal.zzji r0 = r11.c()
            com.google.android.gms.measurement.internal.zzji r3 = com.google.android.gms.measurement.internal.zzji.GRANTED
            if (r0 == r3) goto L85
            com.google.android.gms.measurement.internal.zzji r4 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r0 != r4) goto L3e
            goto L85
        L3e:
            com.google.android.gms.measurement.internal.zzji r11 = com.google.android.gms.measurement.internal.zzji.POLICY
            if (r0 != r11) goto L55
            com.google.android.gms.measurement.internal.zzht r11 = r9.f74432a
            com.google.android.gms.measurement.internal.zzjk r0 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzji r11 = r11.m(r10, r0)
            com.google.android.gms.measurement.internal.zzji r5 = com.google.android.gms.measurement.internal.zzji.UNINITIALIZED
            if (r11 == r5) goto L55
            com.google.android.gms.measurement.internal.zzam r12 = com.google.android.gms.measurement.internal.zzam.REMOTE_ENFORCED_DEFAULT
            r13.c(r0, r12)
            r0 = r11
            goto L8e
        L55:
            com.google.android.gms.measurement.internal.zzht r11 = r9.f74432a
            com.google.android.gms.measurement.internal.zzjk r0 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzjk r5 = r11.Q(r10, r0)
            com.google.android.gms.measurement.internal.zzji r12 = r12.p()
            r6 = 1
            if (r12 == r3) goto L66
            if (r12 != r4) goto L68
        L66:
            r7 = r6
            goto L69
        L68:
            r7 = 0
        L69:
            com.google.android.gms.measurement.internal.zzjk r8 = com.google.android.gms.measurement.internal.zzjk.AD_STORAGE
            if (r5 != r8) goto L76
            if (r7 == 0) goto L76
            com.google.android.gms.measurement.internal.zzam r11 = com.google.android.gms.measurement.internal.zzam.REMOTE_DELEGATION
            r13.c(r0, r11)
            r0 = r12
            goto L8e
        L76:
            com.google.android.gms.measurement.internal.zzam r12 = com.google.android.gms.measurement.internal.zzam.REMOTE_DEFAULT
            r13.c(r0, r12)
            boolean r11 = r11.P(r10, r0)
            if (r6 == r11) goto L83
            r0 = r4
            goto L8e
        L83:
            r0 = r3
            goto L8e
        L85:
            int r2 = r11.b()
            com.google.android.gms.measurement.internal.zzjk r11 = com.google.android.gms.measurement.internal.zzjk.AD_USER_DATA
            r13.b(r11, r2)
        L8e:
            com.google.android.gms.measurement.internal.zzht r11 = r9.f74432a
            boolean r11 = r11.S(r10)
            com.google.android.gms.measurement.internal.zzht r12 = r9.D0()
            java.util.SortedSet r10 = r12.T(r10)
            com.google.android.gms.measurement.internal.zzji r12 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r0 == r12) goto Lbb
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto La7
            goto Lbb
        La7:
            com.google.android.gms.measurement.internal.zzaz r12 = new com.google.android.gms.measurement.internal.zzaz
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            java.lang.String r1 = ""
            if (r11 == 0) goto Lb7
            java.lang.String r1 = android.text.TextUtils.join(r1, r10)
        Lb7:
            r12.<init>(r13, r2, r0, r1)
            return r12
        Lbb:
            com.google.android.gms.measurement.internal.zzaz r10 = new com.google.android.gms.measurement.internal.zzaz
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r10.<init>(r12, r2, r11, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.T0(java.lang.String, com.google.android.gms.measurement.internal.zzaz, com.google.android.gms.measurement.internal.zzjl, com.google.android.gms.measurement.internal.zzan):com.google.android.gms.measurement.internal.zzaz");
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu a() {
        return ((zzic) Preconditions.m(this.f74443l)).a();
    }

    final boolean a0() {
        b().h();
        FileLock fileLock = this.f74454w;
        if (fileLock != null && fileLock.isValid()) {
            a().w().a("Storage concurrent access okay");
            return true;
        }
        this.f74434c.f73997a.w();
        File filesDir = this.f74443l.d().getFilesDir();
        com.google.android.gms.internal.measurement.zzbv.zza();
        int i3 = com.google.android.gms.internal.measurement.zzca.zzb;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.f74455x = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.f74454w = fileLockTryLock;
            if (fileLockTryLock != null) {
                a().w().a("Storage concurrent access okay");
                return true;
            }
            a().o().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e3) {
            a().o().b("Failed to acquire storage lock", e3);
            return false;
        } catch (IOException e4) {
            a().o().b("Failed to access storage lock file", e4);
            return false;
        } catch (OverlappingFileLockException e5) {
            a().r().b("Storage lock already acquired", e5);
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz b() {
        return ((zzic) Preconditions.m(this.f74443l)).b();
    }

    final void b0(zzr zzrVar) {
        if (this.f74456y != null) {
            ArrayList arrayList = new ArrayList();
            this.f74457z = arrayList;
            arrayList.addAll(this.f74456y);
        }
        zzav zzavVarF0 = F0();
        String str = (String) Preconditions.m(zzrVar.f74500a);
        Preconditions.g(str);
        zzavVarF0.h();
        zzavVarF0.j();
        try {
            SQLiteDatabase sQLiteDatabaseU0 = zzavVarF0.u0();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseU0.delete("apps", "app_id=?", strArr) + sQLiteDatabaseU0.delete("events", "app_id=?", strArr) + sQLiteDatabaseU0.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseU0.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseU0.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseU0.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseU0.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseU0.delete("queue", "app_id=?", strArr) + sQLiteDatabaseU0.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseU0.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseU0.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseU0.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseU0.delete("upload_queue", "app_id=?", strArr);
            com.google.android.gms.internal.measurement.zzpo.zza();
            zzic zzicVar = zzavVarF0.f73997a;
            if (zzicVar.w().H(null, zzfy.f73645i1)) {
                iDelete += sQLiteDatabaseU0.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (iDelete > 0) {
                zzicVar.a().w().c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e3) {
            zzavVarF0.f73997a.a().o().c("Error resetting analytics data. appId, error", zzgu.x(str), e3);
        }
        if (zzrVar.f74507i) {
            h0(zzrVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae c() {
        return this.f74443l.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void c0(com.google.android.gms.measurement.internal.zzpl r22, com.google.android.gms.measurement.internal.zzr r23) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.c0(com.google.android.gms.measurement.internal.zzpl, com.google.android.gms.measurement.internal.zzr):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context d() {
        return this.f74443l.d();
    }

    final void d0(String str, zzr zzrVar) {
        b().h();
        O0();
        if (X(zzrVar)) {
            if (!zzrVar.f74507i) {
                o0(zzrVar);
                return;
            }
            Boolean boolZ = Z(zzrVar);
            if ("_npa".equals(str) && boolZ != null) {
                a().v().a("Falling back to manifest metadata value for ad personalization");
                c0(new zzpl("_npa", e().currentTimeMillis(), Long.valueOf(true != boolZ.booleanValue() ? 0L : 1L), "auto"), zzrVar);
                return;
            }
            zzgs zzgsVarV = a().v();
            zzic zzicVar = this.f74443l;
            zzgsVarV.b("Removing user property", zzicVar.D().c(str));
            F0().r0();
            try {
                o0(zzrVar);
                if ("_id".equals(str)) {
                    F0().z0((String) Preconditions.m(zzrVar.f74500a), "_lair");
                }
                F0().z0((String) Preconditions.m(zzrVar.f74500a), str);
                F0().s0();
                a().v().b("User property removed", zzicVar.D().c(str));
                F0().t0();
            } catch (Throwable th) {
                F0().t0();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock e() {
        return ((zzic) Preconditions.m(this.f74443l)).e();
    }

    final void e0() {
        this.f74449r++;
    }

    final void f(String str, zzjl zzjlVar) {
        b().h();
        O0();
        this.B.put(str, zzjlVar);
        F0().L(str, zzjlVar);
    }

    final void f0() {
        this.f74450s++;
    }

    final zzjl g(String str) {
        zzjl zzjlVar = zzjl.f74015c;
        b().h();
        O0();
        zzjl zzjlVarJ = (zzjl) this.B.get(str);
        if (zzjlVarJ == null) {
            zzjlVarJ = F0().J(str);
            if (zzjlVarJ == null) {
                zzjlVarJ = zzjl.f74015c;
            }
            f(str, zzjlVarJ);
        }
        return zzjlVarJ;
    }

    final zzic g0() {
        return this.f74443l;
    }

    final long h() {
        long jCurrentTimeMillis = e().currentTimeMillis();
        zznn zznnVar = this.f74440i;
        zznnVar.j();
        zznnVar.h();
        zzhe zzheVar = zznnVar.f74336j;
        long jA = zzheVar.a();
        if (jA == 0) {
            jA = ((long) zznnVar.f73997a.C().q0().nextInt(86400000)) + 1;
            zzheVar.b(jA);
        }
        return ((((jCurrentTimeMillis + jA) / 1000) / 60) / 60) / 24;
    }

    final void i(zzbg zzbgVar, String str) {
        zzh zzhVarJ0 = F0().J0(str);
        if (zzhVarJ0 == null || TextUtils.isEmpty(zzhVarJ0.D0())) {
            a().v().b("No app data available; dropping event", str);
            return;
        }
        Boolean boolT = T(zzhVarJ0);
        if (boolT == null) {
            if (!"_ui".equals(zzbgVar.f73484a)) {
                a().r().b("Could not find package. appId", zzgu.x(str));
            }
        } else if (!boolT.booleanValue()) {
            a().o().b("App version does not match; dropping event. appId", zzgu.x(str));
            return;
        }
        j(zzbgVar, new zzr(str, zzhVarJ0.r0(), zzhVarJ0.D0(), zzhVarJ0.F0(), zzhVarJ0.H0(), zzhVarJ0.J0(), zzhVarJ0.L0(), (String) null, zzhVarJ0.d(), false, zzhVarJ0.x0(), 0L, 0, zzhVarJ0.P(), false, zzhVarJ0.R(), zzhVarJ0.b(), zzhVarJ0.T(), g(str).l(), "", (String) null, zzhVarJ0.V(), zzhVarJ0.X(), g(str).b(), R0(str).e(), zzhVarJ0.b0(), zzhVarJ0.j0(), zzhVarJ0.l0(), zzhVarJ0.I(), 0L, zzhVarJ0.M()));
    }

    final void i0(zzr zzrVar) throws Throwable {
        b().h();
        O0();
        Preconditions.m(zzrVar);
        String str = zzrVar.f74500a;
        Preconditions.g(str);
        int i3 = 0;
        if (B0().H(null, zzfy.A0)) {
            long jCurrentTimeMillis = e().currentTimeMillis();
            int iE = B0().E(null, zzfy.f73647j0);
            B0();
            long jN = jCurrentTimeMillis - zzal.n();
            while (i3 < iE && M(null, jN)) {
                i3++;
            }
        } else {
            B0();
            long jP = zzal.p();
            while (i3 < jP && M(str, 0L)) {
                i3++;
            }
        }
        if (B0().H(null, zzfy.B0)) {
            b().h();
            v0();
        }
        if (this.f74441j.j(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.F))) {
            a().w().b("[sgtm] Going background, trigger client side upload. appId", str);
            s(str, e().currentTimeMillis());
        }
    }

    final void j(zzbg zzbgVar, zzr zzrVar) {
        String str = zzrVar.f74500a;
        Preconditions.g(str);
        zzgv zzgvVarA = zzgv.a(zzbgVar);
        N0().w(zzgvVarA.f73742d, F0().G(str));
        N0().u(zzgvVarA, B0().w(str));
        zzbg zzbgVarB = zzgvVarA.b();
        if (!B0().H(null, zzfy.f73639g1) && "_cmp".equals(zzbgVarB.f73484a)) {
            zzbe zzbeVar = zzbgVarB.f73485b;
            if ("referrer API v2".equals(zzbeVar.g0("_cis"))) {
                String strG0 = zzbeVar.g0("gclid");
                if (!TextUtils.isEmpty(strG0)) {
                    c0(new zzpl("_lgclid", zzbgVarB.f73487d, strG0, "auto"), zzrVar);
                }
            }
        }
        k(zzbgVarB, zzrVar);
    }

    final void j0(zzah zzahVar) {
        zzr zzrVarU = U((String) Preconditions.m(zzahVar.f73386a));
        if (zzrVarU != null) {
            k0(zzahVar, zzrVarU);
        }
    }

    final void k(zzbg zzbgVar, zzr zzrVar) {
        zzbg zzbgVar2;
        List<zzah> listI0;
        List<zzah> listI02;
        List<zzah> listI03;
        String str;
        Preconditions.m(zzrVar);
        String str2 = zzrVar.f74500a;
        Preconditions.g(str2);
        b().h();
        O0();
        long j3 = zzbgVar.f73487d;
        zzgv zzgvVarA = zzgv.a(zzbgVar);
        b().h();
        zzpp.k0((this.F == null || (str = this.G) == null || !str.equals(str2)) ? null : this.F, zzgvVarA.f73742d, false);
        zzbg zzbgVarB = zzgvVarA.b();
        K0();
        if (zzpk.p(zzbgVarB, zzrVar)) {
            if (!zzrVar.f74507i) {
                o0(zzrVar);
                return;
            }
            List list = zzrVar.f74517s;
            if (list != null) {
                String str3 = zzbgVarB.f73484a;
                if (!list.contains(str3)) {
                    a().v().d("Dropping non-safelisted event. appId, event name, origin", str2, zzbgVarB.f73484a, zzbgVarB.f73486c);
                    return;
                } else {
                    Bundle bundleW0 = zzbgVarB.f73485b.w0();
                    bundleW0.putLong("ga_safelisted", 1L);
                    zzbgVar2 = new zzbg(str3, new zzbe(bundleW0), zzbgVarB.f73486c, zzbgVarB.f73487d);
                }
            } else {
                zzbgVar2 = zzbgVarB;
            }
            F0().r0();
            try {
                String str4 = zzbgVar2.f73484a;
                if ("_s".equals(str4) && !F0().C(str2, "_s") && zzbgVar2.f73485b.N("_sid").longValue() != 0) {
                    if (F0().C(str2, "_f") || F0().C(str2, "_v")) {
                        F0().I(str2, null, "_sid", l(str2, zzbgVar2));
                    } else {
                        F0().I(str2, Long.valueOf(e().currentTimeMillis() - 15000), "_sid", l(str2, zzbgVar2));
                    }
                }
                zzav zzavVarF0 = F0();
                Preconditions.g(str2);
                zzavVarF0.h();
                zzavVarF0.j();
                if (j3 < 0) {
                    zzavVarF0.f73997a.a().r().c("Invalid time querying timed out conditional properties", zzgu.x(str2), Long.valueOf(j3));
                    listI0 = Collections.EMPTY_LIST;
                } else {
                    listI0 = zzavVarF0.I0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j3)});
                }
                for (zzah zzahVar : listI0) {
                    if (zzahVar != null) {
                        a().w().d("User property timed out", zzahVar.f73386a, this.f74443l.D().c(zzahVar.f73388c.f74478b), zzahVar.f73388c.zza());
                        zzbg zzbgVar3 = zzahVar.f73392h;
                        if (zzbgVar3 != null) {
                            m(new zzbg(zzbgVar3, j3), zzrVar);
                        }
                        F0().G0(str2, zzahVar.f73388c.f74478b);
                    }
                }
                zzav zzavVarF02 = F0();
                Preconditions.g(str2);
                zzavVarF02.h();
                zzavVarF02.j();
                if (j3 < 0) {
                    zzavVarF02.f73997a.a().r().c("Invalid time querying expired conditional properties", zzgu.x(str2), Long.valueOf(j3));
                    listI02 = Collections.EMPTY_LIST;
                } else {
                    listI02 = zzavVarF02.I0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j3)});
                }
                ArrayList arrayList = new ArrayList(listI02.size());
                for (zzah zzahVar2 : listI02) {
                    if (zzahVar2 != null) {
                        a().w().d("User property expired", zzahVar2.f73386a, this.f74443l.D().c(zzahVar2.f73388c.f74478b), zzahVar2.f73388c.zza());
                        F0().z0(str2, zzahVar2.f73388c.f74478b);
                        zzbg zzbgVar4 = zzahVar2.f73396l;
                        if (zzbgVar4 != null) {
                            arrayList.add(zzbgVar4);
                        }
                        F0().G0(str2, zzahVar2.f73388c.f74478b);
                    }
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    m(new zzbg((zzbg) obj, j3), zzrVar);
                }
                zzav zzavVarF03 = F0();
                Preconditions.g(str2);
                Preconditions.g(str4);
                zzavVarF03.h();
                zzavVarF03.j();
                if (j3 < 0) {
                    zzic zzicVar = zzavVarF03.f73997a;
                    zzicVar.a().r().d("Invalid time querying triggered conditional properties", zzgu.x(str2), zzicVar.D().a(str4), Long.valueOf(j3));
                    listI03 = Collections.EMPTY_LIST;
                } else {
                    listI03 = zzavVarF03.I0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j3)});
                }
                ArrayList arrayList2 = new ArrayList(listI03.size());
                for (zzah zzahVar3 : listI03) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.f73388c;
                        zzpn zzpnVar = new zzpn((String) Preconditions.m(zzahVar3.f73386a), zzahVar3.f73387b, zzplVar.f74478b, j3, Preconditions.m(zzplVar.zza()));
                        if (F0().A0(zzpnVar)) {
                            a().w().d("User property triggered", zzahVar3.f73386a, this.f74443l.D().c(zzpnVar.f74486c), zzpnVar.f74488e);
                        } else {
                            a().o().d("Too many active user properties, ignoring", zzgu.x(zzahVar3.f73386a), this.f74443l.D().c(zzpnVar.f74486c), zzpnVar.f74488e);
                        }
                        zzbg zzbgVar5 = zzahVar3.f73394j;
                        if (zzbgVar5 != null) {
                            arrayList2.add(zzbgVar5);
                        }
                        zzahVar3.f73388c = new zzpl(zzpnVar);
                        zzahVar3.f73390f = true;
                        F0().E0(zzahVar3);
                    }
                }
                m(zzbgVar2, zzrVar);
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    m(new zzbg((zzbg) obj2, j3), zzrVar);
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                F0().t0();
                throw th;
            }
        }
    }

    final void k0(zzah zzahVar, zzr zzrVar) {
        Preconditions.m(zzahVar);
        Preconditions.g(zzahVar.f73386a);
        Preconditions.m(zzahVar.f73387b);
        Preconditions.m(zzahVar.f73388c);
        Preconditions.g(zzahVar.f73388c.f74478b);
        b().h();
        O0();
        if (X(zzrVar)) {
            if (!zzrVar.f74507i) {
                o0(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z2 = false;
            zzahVar2.f73390f = false;
            F0().r0();
            try {
                zzah zzahVarF0 = F0().F0((String) Preconditions.m(zzahVar2.f73386a), zzahVar2.f73388c.f74478b);
                if (zzahVarF0 != null && !zzahVarF0.f73387b.equals(zzahVar2.f73387b)) {
                    a().r().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f74443l.D().c(zzahVar2.f73388c.f74478b), zzahVar2.f73387b, zzahVarF0.f73387b);
                }
                if (zzahVarF0 != null && zzahVarF0.f73390f) {
                    zzahVar2.f73387b = zzahVarF0.f73387b;
                    zzahVar2.f73389d = zzahVarF0.f73389d;
                    zzahVar2.f73393i = zzahVarF0.f73393i;
                    zzahVar2.f73391g = zzahVarF0.f73391g;
                    zzahVar2.f73394j = zzahVarF0.f73394j;
                    zzahVar2.f73390f = true;
                    zzpl zzplVar = zzahVar2.f73388c;
                    zzahVar2.f73388c = new zzpl(zzplVar.f74478b, zzahVarF0.f73388c.f74479c, zzplVar.zza(), zzahVarF0.f73388c.f74482g);
                } else if (TextUtils.isEmpty(zzahVar2.f73391g)) {
                    zzpl zzplVar2 = zzahVar2.f73388c;
                    zzahVar2.f73388c = new zzpl(zzplVar2.f74478b, zzahVar2.f73389d, zzplVar2.zza(), zzahVar2.f73388c.f74482g);
                    zzahVar2.f73390f = true;
                    z2 = true;
                }
                if (zzahVar2.f73390f) {
                    zzpl zzplVar3 = zzahVar2.f73388c;
                    zzpn zzpnVar = new zzpn((String) Preconditions.m(zzahVar2.f73386a), zzahVar2.f73387b, zzplVar3.f74478b, zzplVar3.f74479c, Preconditions.m(zzplVar3.zza()));
                    if (F0().A0(zzpnVar)) {
                        a().v().d("User property updated immediately", zzahVar2.f73386a, this.f74443l.D().c(zzpnVar.f74486c), zzpnVar.f74488e);
                    } else {
                        a().o().d("(2)Too many active user properties, ignoring", zzgu.x(zzahVar2.f73386a), this.f74443l.D().c(zzpnVar.f74486c), zzpnVar.f74488e);
                    }
                    if (z2 && zzahVar2.f73394j != null) {
                        m(new zzbg(zzahVar2.f73394j, zzahVar2.f73389d), zzrVar);
                    }
                }
                if (F0().E0(zzahVar2)) {
                    a().v().d("Conditional property added", zzahVar2.f73386a, this.f74443l.D().c(zzahVar2.f73388c.f74478b), zzahVar2.f73388c.zza());
                } else {
                    a().o().d("Too many conditional properties, ignoring", zzgu.x(zzahVar2.f73386a), this.f74443l.D().c(zzahVar2.f73388c.f74478b), zzahVar2.f73388c.zza());
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                F0().t0();
                throw th;
            }
        }
    }

    final Bundle l(String str, zzbg zzbgVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbgVar.f73485b.N("_sid").longValue());
        zzpn zzpnVarB0 = F0().B0(str, "_sno");
        if (zzpnVarB0 != null) {
            Object obj = zzpnVarB0.f74488e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    final void l0(zzah zzahVar) {
        zzr zzrVarU = U((String) Preconditions.m(zzahVar.f73386a));
        if (zzrVarU != null) {
            m0(zzahVar, zzrVarU);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0367 A[Catch: all -> 0x0176, TryCatch #5 {all -> 0x0176, blocks: (B:36:0x0155, B:39:0x0164, B:41:0x016c, B:47:0x0179, B:89:0x02f3, B:98:0x0326, B:100:0x0367, B:102:0x036c, B:103:0x0383, B:105:0x038e, B:107:0x03a7, B:109:0x03ac, B:110:0x03c3, B:113:0x03e5, B:117:0x0408, B:118:0x041f, B:120:0x042b, B:123:0x0448, B:124:0x045c, B:126:0x0464, B:128:0x0470, B:130:0x0476, B:131:0x047d, B:133:0x048a, B:135:0x0492, B:137:0x049a, B:139:0x04a2, B:140:0x04ae, B:141:0x04bb, B:147:0x04fd, B:148:0x0512, B:150:0x0534, B:153:0x054b, B:156:0x0586, B:158:0x05b1, B:160:0x05e9, B:161:0x05ec, B:163:0x05f4, B:164:0x05f7, B:166:0x05ff, B:167:0x0602, B:169:0x060a, B:170:0x060d, B:172:0x0616, B:173:0x061a, B:175:0x0627, B:176:0x062a, B:178:0x0656, B:180:0x0660, B:184:0x0675, B:189:0x0681, B:192:0x068a, B:196:0x0697, B:200:0x06a5, B:204:0x06b3, B:208:0x06c1, B:212:0x06cf, B:216:0x06da, B:220:0x06e7, B:221:0x06f3, B:223:0x06f9, B:224:0x06fc, B:226:0x071f, B:229:0x0728, B:232:0x0731, B:233:0x074b, B:235:0x0751, B:237:0x0765, B:239:0x0771, B:241:0x077e, B:244:0x0797, B:245:0x07a7, B:249:0x07b0, B:250:0x07b3, B:252:0x07c0, B:253:0x07c5, B:255:0x07e3, B:257:0x07e7, B:259:0x07f7, B:261:0x0802, B:262:0x080b, B:264:0x0815, B:266:0x0821, B:268:0x082b, B:270:0x0831, B:272:0x0840, B:274:0x0856, B:276:0x085c, B:277:0x0865, B:279:0x0873, B:281:0x08af, B:283:0x08b9, B:284:0x08bc, B:286:0x08c6, B:288:0x08e2, B:289:0x08ed, B:291:0x0925, B:293:0x092d, B:295:0x0937, B:296:0x0944, B:298:0x094e, B:299:0x095b, B:300:0x0964, B:302:0x096a, B:304:0x09a6, B:306:0x09b0, B:308:0x09c2, B:310:0x09c8, B:311:0x0a0d, B:312:0x0a18, B:313:0x0a23, B:315:0x0a29, B:324:0x0a76, B:325:0x0ac1, B:327:0x0ad2, B:341:0x0b33, B:332:0x0aea, B:333:0x0aed, B:318:0x0a36, B:320:0x0a62, B:338:0x0b06, B:339:0x0b1d, B:340:0x0b1e, B:227:0x0722, B:157:0x05a3, B:144:0x04e4, B:92:0x0307, B:93:0x030e, B:95:0x0314, B:97:0x0320, B:54:0x0191, B:56:0x019d, B:58:0x01b2, B:64:0x01d2, B:69:0x0208, B:71:0x020e, B:73:0x021c, B:75:0x022a, B:78:0x0236, B:86:0x02bc, B:88:0x02c6, B:80:0x025f, B:81:0x0278, B:85:0x029f, B:84:0x028b, B:67:0x01de, B:68:0x01fc), top: B:356:0x0155, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0870  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018d A[PHI: r28 r29
      0x018d: PHI (r28v6 java.lang.String) = (r28v1 java.lang.String), (r28v1 java.lang.String), (r28v7 java.lang.String) binds: [B:70:0x020c, B:72:0x021a, B:52:0x0189] A[DONT_GENERATE, DONT_INLINE]
      0x018d: PHI (r29v6 java.lang.String) = (r29v1 java.lang.String), (r29v1 java.lang.String), (r29v7 java.lang.String) binds: [B:70:0x020c, B:72:0x021a, B:52:0x0189] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019d A[Catch: all -> 0x0176, TryCatch #5 {all -> 0x0176, blocks: (B:36:0x0155, B:39:0x0164, B:41:0x016c, B:47:0x0179, B:89:0x02f3, B:98:0x0326, B:100:0x0367, B:102:0x036c, B:103:0x0383, B:105:0x038e, B:107:0x03a7, B:109:0x03ac, B:110:0x03c3, B:113:0x03e5, B:117:0x0408, B:118:0x041f, B:120:0x042b, B:123:0x0448, B:124:0x045c, B:126:0x0464, B:128:0x0470, B:130:0x0476, B:131:0x047d, B:133:0x048a, B:135:0x0492, B:137:0x049a, B:139:0x04a2, B:140:0x04ae, B:141:0x04bb, B:147:0x04fd, B:148:0x0512, B:150:0x0534, B:153:0x054b, B:156:0x0586, B:158:0x05b1, B:160:0x05e9, B:161:0x05ec, B:163:0x05f4, B:164:0x05f7, B:166:0x05ff, B:167:0x0602, B:169:0x060a, B:170:0x060d, B:172:0x0616, B:173:0x061a, B:175:0x0627, B:176:0x062a, B:178:0x0656, B:180:0x0660, B:184:0x0675, B:189:0x0681, B:192:0x068a, B:196:0x0697, B:200:0x06a5, B:204:0x06b3, B:208:0x06c1, B:212:0x06cf, B:216:0x06da, B:220:0x06e7, B:221:0x06f3, B:223:0x06f9, B:224:0x06fc, B:226:0x071f, B:229:0x0728, B:232:0x0731, B:233:0x074b, B:235:0x0751, B:237:0x0765, B:239:0x0771, B:241:0x077e, B:244:0x0797, B:245:0x07a7, B:249:0x07b0, B:250:0x07b3, B:252:0x07c0, B:253:0x07c5, B:255:0x07e3, B:257:0x07e7, B:259:0x07f7, B:261:0x0802, B:262:0x080b, B:264:0x0815, B:266:0x0821, B:268:0x082b, B:270:0x0831, B:272:0x0840, B:274:0x0856, B:276:0x085c, B:277:0x0865, B:279:0x0873, B:281:0x08af, B:283:0x08b9, B:284:0x08bc, B:286:0x08c6, B:288:0x08e2, B:289:0x08ed, B:291:0x0925, B:293:0x092d, B:295:0x0937, B:296:0x0944, B:298:0x094e, B:299:0x095b, B:300:0x0964, B:302:0x096a, B:304:0x09a6, B:306:0x09b0, B:308:0x09c2, B:310:0x09c8, B:311:0x0a0d, B:312:0x0a18, B:313:0x0a23, B:315:0x0a29, B:324:0x0a76, B:325:0x0ac1, B:327:0x0ad2, B:341:0x0b33, B:332:0x0aea, B:333:0x0aed, B:318:0x0a36, B:320:0x0a62, B:338:0x0b06, B:339:0x0b1d, B:340:0x0b1e, B:227:0x0722, B:157:0x05a3, B:144:0x04e4, B:92:0x0307, B:93:0x030e, B:95:0x0314, B:97:0x0320, B:54:0x0191, B:56:0x019d, B:58:0x01b2, B:64:0x01d2, B:69:0x0208, B:71:0x020e, B:73:0x021c, B:75:0x022a, B:78:0x0236, B:86:0x02bc, B:88:0x02c6, B:80:0x025f, B:81:0x0278, B:85:0x029f, B:84:0x028b, B:67:0x01de, B:68:0x01fc), top: B:356:0x0155, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fc A[Catch: all -> 0x0176, TryCatch #5 {all -> 0x0176, blocks: (B:36:0x0155, B:39:0x0164, B:41:0x016c, B:47:0x0179, B:89:0x02f3, B:98:0x0326, B:100:0x0367, B:102:0x036c, B:103:0x0383, B:105:0x038e, B:107:0x03a7, B:109:0x03ac, B:110:0x03c3, B:113:0x03e5, B:117:0x0408, B:118:0x041f, B:120:0x042b, B:123:0x0448, B:124:0x045c, B:126:0x0464, B:128:0x0470, B:130:0x0476, B:131:0x047d, B:133:0x048a, B:135:0x0492, B:137:0x049a, B:139:0x04a2, B:140:0x04ae, B:141:0x04bb, B:147:0x04fd, B:148:0x0512, B:150:0x0534, B:153:0x054b, B:156:0x0586, B:158:0x05b1, B:160:0x05e9, B:161:0x05ec, B:163:0x05f4, B:164:0x05f7, B:166:0x05ff, B:167:0x0602, B:169:0x060a, B:170:0x060d, B:172:0x0616, B:173:0x061a, B:175:0x0627, B:176:0x062a, B:178:0x0656, B:180:0x0660, B:184:0x0675, B:189:0x0681, B:192:0x068a, B:196:0x0697, B:200:0x06a5, B:204:0x06b3, B:208:0x06c1, B:212:0x06cf, B:216:0x06da, B:220:0x06e7, B:221:0x06f3, B:223:0x06f9, B:224:0x06fc, B:226:0x071f, B:229:0x0728, B:232:0x0731, B:233:0x074b, B:235:0x0751, B:237:0x0765, B:239:0x0771, B:241:0x077e, B:244:0x0797, B:245:0x07a7, B:249:0x07b0, B:250:0x07b3, B:252:0x07c0, B:253:0x07c5, B:255:0x07e3, B:257:0x07e7, B:259:0x07f7, B:261:0x0802, B:262:0x080b, B:264:0x0815, B:266:0x0821, B:268:0x082b, B:270:0x0831, B:272:0x0840, B:274:0x0856, B:276:0x085c, B:277:0x0865, B:279:0x0873, B:281:0x08af, B:283:0x08b9, B:284:0x08bc, B:286:0x08c6, B:288:0x08e2, B:289:0x08ed, B:291:0x0925, B:293:0x092d, B:295:0x0937, B:296:0x0944, B:298:0x094e, B:299:0x095b, B:300:0x0964, B:302:0x096a, B:304:0x09a6, B:306:0x09b0, B:308:0x09c2, B:310:0x09c8, B:311:0x0a0d, B:312:0x0a18, B:313:0x0a23, B:315:0x0a29, B:324:0x0a76, B:325:0x0ac1, B:327:0x0ad2, B:341:0x0b33, B:332:0x0aea, B:333:0x0aed, B:318:0x0a36, B:320:0x0a62, B:338:0x0b06, B:339:0x0b1d, B:340:0x0b1e, B:227:0x0722, B:157:0x05a3, B:144:0x04e4, B:92:0x0307, B:93:0x030e, B:95:0x0314, B:97:0x0320, B:54:0x0191, B:56:0x019d, B:58:0x01b2, B:64:0x01d2, B:69:0x0208, B:71:0x020e, B:73:0x021c, B:75:0x022a, B:78:0x0236, B:86:0x02bc, B:88:0x02c6, B:80:0x025f, B:81:0x0278, B:85:0x029f, B:84:0x028b, B:67:0x01de, B:68:0x01fc), top: B:356:0x0155, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020e A[Catch: all -> 0x0176, TryCatch #5 {all -> 0x0176, blocks: (B:36:0x0155, B:39:0x0164, B:41:0x016c, B:47:0x0179, B:89:0x02f3, B:98:0x0326, B:100:0x0367, B:102:0x036c, B:103:0x0383, B:105:0x038e, B:107:0x03a7, B:109:0x03ac, B:110:0x03c3, B:113:0x03e5, B:117:0x0408, B:118:0x041f, B:120:0x042b, B:123:0x0448, B:124:0x045c, B:126:0x0464, B:128:0x0470, B:130:0x0476, B:131:0x047d, B:133:0x048a, B:135:0x0492, B:137:0x049a, B:139:0x04a2, B:140:0x04ae, B:141:0x04bb, B:147:0x04fd, B:148:0x0512, B:150:0x0534, B:153:0x054b, B:156:0x0586, B:158:0x05b1, B:160:0x05e9, B:161:0x05ec, B:163:0x05f4, B:164:0x05f7, B:166:0x05ff, B:167:0x0602, B:169:0x060a, B:170:0x060d, B:172:0x0616, B:173:0x061a, B:175:0x0627, B:176:0x062a, B:178:0x0656, B:180:0x0660, B:184:0x0675, B:189:0x0681, B:192:0x068a, B:196:0x0697, B:200:0x06a5, B:204:0x06b3, B:208:0x06c1, B:212:0x06cf, B:216:0x06da, B:220:0x06e7, B:221:0x06f3, B:223:0x06f9, B:224:0x06fc, B:226:0x071f, B:229:0x0728, B:232:0x0731, B:233:0x074b, B:235:0x0751, B:237:0x0765, B:239:0x0771, B:241:0x077e, B:244:0x0797, B:245:0x07a7, B:249:0x07b0, B:250:0x07b3, B:252:0x07c0, B:253:0x07c5, B:255:0x07e3, B:257:0x07e7, B:259:0x07f7, B:261:0x0802, B:262:0x080b, B:264:0x0815, B:266:0x0821, B:268:0x082b, B:270:0x0831, B:272:0x0840, B:274:0x0856, B:276:0x085c, B:277:0x0865, B:279:0x0873, B:281:0x08af, B:283:0x08b9, B:284:0x08bc, B:286:0x08c6, B:288:0x08e2, B:289:0x08ed, B:291:0x0925, B:293:0x092d, B:295:0x0937, B:296:0x0944, B:298:0x094e, B:299:0x095b, B:300:0x0964, B:302:0x096a, B:304:0x09a6, B:306:0x09b0, B:308:0x09c2, B:310:0x09c8, B:311:0x0a0d, B:312:0x0a18, B:313:0x0a23, B:315:0x0a29, B:324:0x0a76, B:325:0x0ac1, B:327:0x0ad2, B:341:0x0b33, B:332:0x0aea, B:333:0x0aed, B:318:0x0a36, B:320:0x0a62, B:338:0x0b06, B:339:0x0b1d, B:340:0x0b1e, B:227:0x0722, B:157:0x05a3, B:144:0x04e4, B:92:0x0307, B:93:0x030e, B:95:0x0314, B:97:0x0320, B:54:0x0191, B:56:0x019d, B:58:0x01b2, B:64:0x01d2, B:69:0x0208, B:71:0x020e, B:73:0x021c, B:75:0x022a, B:78:0x0236, B:86:0x02bc, B:88:0x02c6, B:80:0x025f, B:81:0x0278, B:85:0x029f, B:84:0x028b, B:67:0x01de, B:68:0x01fc), top: B:356:0x0155, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0307 A[Catch: all -> 0x0176, TryCatch #5 {all -> 0x0176, blocks: (B:36:0x0155, B:39:0x0164, B:41:0x016c, B:47:0x0179, B:89:0x02f3, B:98:0x0326, B:100:0x0367, B:102:0x036c, B:103:0x0383, B:105:0x038e, B:107:0x03a7, B:109:0x03ac, B:110:0x03c3, B:113:0x03e5, B:117:0x0408, B:118:0x041f, B:120:0x042b, B:123:0x0448, B:124:0x045c, B:126:0x0464, B:128:0x0470, B:130:0x0476, B:131:0x047d, B:133:0x048a, B:135:0x0492, B:137:0x049a, B:139:0x04a2, B:140:0x04ae, B:141:0x04bb, B:147:0x04fd, B:148:0x0512, B:150:0x0534, B:153:0x054b, B:156:0x0586, B:158:0x05b1, B:160:0x05e9, B:161:0x05ec, B:163:0x05f4, B:164:0x05f7, B:166:0x05ff, B:167:0x0602, B:169:0x060a, B:170:0x060d, B:172:0x0616, B:173:0x061a, B:175:0x0627, B:176:0x062a, B:178:0x0656, B:180:0x0660, B:184:0x0675, B:189:0x0681, B:192:0x068a, B:196:0x0697, B:200:0x06a5, B:204:0x06b3, B:208:0x06c1, B:212:0x06cf, B:216:0x06da, B:220:0x06e7, B:221:0x06f3, B:223:0x06f9, B:224:0x06fc, B:226:0x071f, B:229:0x0728, B:232:0x0731, B:233:0x074b, B:235:0x0751, B:237:0x0765, B:239:0x0771, B:241:0x077e, B:244:0x0797, B:245:0x07a7, B:249:0x07b0, B:250:0x07b3, B:252:0x07c0, B:253:0x07c5, B:255:0x07e3, B:257:0x07e7, B:259:0x07f7, B:261:0x0802, B:262:0x080b, B:264:0x0815, B:266:0x0821, B:268:0x082b, B:270:0x0831, B:272:0x0840, B:274:0x0856, B:276:0x085c, B:277:0x0865, B:279:0x0873, B:281:0x08af, B:283:0x08b9, B:284:0x08bc, B:286:0x08c6, B:288:0x08e2, B:289:0x08ed, B:291:0x0925, B:293:0x092d, B:295:0x0937, B:296:0x0944, B:298:0x094e, B:299:0x095b, B:300:0x0964, B:302:0x096a, B:304:0x09a6, B:306:0x09b0, B:308:0x09c2, B:310:0x09c8, B:311:0x0a0d, B:312:0x0a18, B:313:0x0a23, B:315:0x0a29, B:324:0x0a76, B:325:0x0ac1, B:327:0x0ad2, B:341:0x0b33, B:332:0x0aea, B:333:0x0aed, B:318:0x0a36, B:320:0x0a62, B:338:0x0b06, B:339:0x0b1d, B:340:0x0b1e, B:227:0x0722, B:157:0x05a3, B:144:0x04e4, B:92:0x0307, B:93:0x030e, B:95:0x0314, B:97:0x0320, B:54:0x0191, B:56:0x019d, B:58:0x01b2, B:64:0x01d2, B:69:0x0208, B:71:0x020e, B:73:0x021c, B:75:0x022a, B:78:0x0236, B:86:0x02bc, B:88:0x02c6, B:80:0x025f, B:81:0x0278, B:85:0x029f, B:84:0x028b, B:67:0x01de, B:68:0x01fc), top: B:356:0x0155, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void m(com.google.android.gms.measurement.internal.zzbg r45, com.google.android.gms.measurement.internal.zzr r46) {
        /*
            Method dump skipped, instruction units count: 2924
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.m(com.google.android.gms.measurement.internal.zzbg, com.google.android.gms.measurement.internal.zzr):void");
    }

    final void m0(zzah zzahVar, zzr zzrVar) {
        Preconditions.m(zzahVar);
        Preconditions.g(zzahVar.f73386a);
        Preconditions.m(zzahVar.f73388c);
        Preconditions.g(zzahVar.f73388c.f74478b);
        b().h();
        O0();
        if (X(zzrVar)) {
            if (!zzrVar.f74507i) {
                o0(zzrVar);
                return;
            }
            F0().r0();
            try {
                o0(zzrVar);
                String str = (String) Preconditions.m(zzahVar.f73386a);
                zzah zzahVarF0 = F0().F0(str, zzahVar.f73388c.f74478b);
                if (zzahVarF0 != null) {
                    a().v().c("Removing conditional user property", zzahVar.f73386a, this.f74443l.D().c(zzahVar.f73388c.f74478b));
                    F0().G0(str, zzahVar.f73388c.f74478b);
                    if (zzahVarF0.f73390f) {
                        F0().z0(str, zzahVar.f73388c.f74478b);
                    }
                    zzbg zzbgVar = zzahVar.f73396l;
                    if (zzbgVar != null) {
                        zzbe zzbeVar = zzbgVar.f73485b;
                        m((zzbg) Preconditions.m(N0().R(str, ((zzbg) Preconditions.m(zzbgVar)).f73484a, zzbeVar != null ? zzbeVar.w0() : null, zzahVarF0.f73387b, zzbgVar.f73487d, true, true)), zzrVar);
                    }
                } else {
                    a().r().c("Conditional user property doesn't exist", zzgu.x(zzahVar.f73386a), this.f74443l.D().c(zzahVar.f73388c.f74478b));
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                F0().t0();
                throw th;
            }
        }
    }

    final void n(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        b().h();
        O0();
        zzan zzanVarD = zzan.d(zzicVar.zzaA());
        String strO0 = zzhVar.o0();
        b().h();
        O0();
        zzjl zzjlVarG = g(strO0);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int iOrdinal = zzjlVarG.p().ordinal();
        if (iOrdinal == 1) {
            zzanVarD.c(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            zzanVarD.b(zzjk.AD_STORAGE, zzjlVarG.b());
        } else {
            zzanVarD.c(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int iOrdinal2 = zzjlVarG.q().ordinal();
        if (iOrdinal2 == 1) {
            zzanVarD.c(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            zzanVarD.b(zzjk.ANALYTICS_STORAGE, zzjlVarG.b());
        } else {
            zzanVarD.c(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String strO02 = zzhVar.o0();
        b().h();
        O0();
        zzaz zzazVarT0 = T0(strO02, R0(strO02), g(strO02), zzanVarD);
        zzicVar.zzaD(((Boolean) Preconditions.m(zzazVarT0.j())).booleanValue());
        if (!TextUtils.isEmpty(zzazVarT0.k())) {
            zzicVar.zzaF(zzazVarT0.k());
        }
        b().h();
        O0();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (it.hasNext()) {
                zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
                if ("_npa".equals(zziuVar.zzc())) {
                    break;
                }
            } else {
                zziuVar = null;
                break;
            }
        }
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzanVarD.a(zzjkVar) == zzam.UNSET) {
                zzpn zzpnVarB0 = F0().B0(zzhVar.o0(), "_npa");
                if (zzpnVarB0 != null) {
                    String str = zzpnVarB0.f74485b;
                    if ("tcf".equals(str)) {
                        zzanVarD.c(zzjkVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzanVarD.c(zzjkVar, zzam.API);
                    } else {
                        zzanVarD.c(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean boolR = zzhVar.R();
                    if (boolR == null || ((boolR.booleanValue() && zziuVar.zzg() != 1) || !(boolR.booleanValue() || zziuVar.zzg() == 0))) {
                        zzanVarD.c(zzjkVar, zzam.API);
                    } else {
                        zzanVarD.c(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int I = I(zzhVar.o0(), zzanVarD);
            com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
            zzitVarZzm.zzb("_npa");
            zzitVarZzm.zza(e().currentTimeMillis());
            zzitVarZzm.zze(I);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbc());
            a().w().c("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(I));
        }
        zzicVar.zzaB(zzanVarD.toString());
        boolean zS = this.f74432a.S(zzhVar.o0());
        List listZzb = zzicVar.zzb();
        int i3 = 0;
        for (int i4 = 0; i4 < listZzb.size(); i4++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i4)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i4)).zzcl();
                List listZza = zzhrVar.zza();
                int i5 = 0;
                while (true) {
                    if (i5 >= listZza.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i5)).zzb())) {
                        String strZzd = ((com.google.android.gms.internal.measurement.zzhw) listZza.get(i5)).zzd();
                        if (zS && strZzd.length() > 4) {
                            char[] charArray = strZzd.toCharArray();
                            int i6 = 1;
                            while (true) {
                                if (i6 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i6)) {
                                    i3 = i6;
                                    break;
                                }
                                i6++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3 | 1);
                            strZzd = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzhvVarZzn.zzb("_tcfd");
                        zzhvVarZzn.zzd(strZzd);
                        zzhrVar.zze(i5, zzhvVarZzn);
                    } else {
                        i5++;
                    }
                }
                zzicVar.zzf(i4, zzhrVar);
                return;
            }
        }
    }

    final void n0(zzr zzrVar, long j3) {
        zzh zzhVarJ0 = F0().J0((String) Preconditions.m(zzrVar.f74500a));
        if (zzhVarJ0 != null && N0().p(zzrVar.f74501b, zzhVarJ0.r0())) {
            a().r().b("New GMP App Id passed in. Removing cached database data. appId", zzgu.x(zzhVarJ0.o0()));
            zzav zzavVarF0 = F0();
            String strO0 = zzhVarJ0.o0();
            zzavVarF0.j();
            zzavVarF0.h();
            Preconditions.g(strO0);
            try {
                SQLiteDatabase sQLiteDatabaseU0 = zzavVarF0.u0();
                String[] strArr = {strO0};
                int iDelete = sQLiteDatabaseU0.delete("events", "app_id=?", strArr) + sQLiteDatabaseU0.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseU0.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseU0.delete("apps", "app_id=?", strArr) + sQLiteDatabaseU0.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseU0.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseU0.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseU0.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseU0.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseU0.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseU0.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseU0.delete("trigger_uris", "app_id=?", strArr);
                com.google.android.gms.internal.measurement.zzpo.zza();
                zzic zzicVar = zzavVarF0.f73997a;
                if (zzicVar.w().H(null, zzfy.f73645i1)) {
                    iDelete += sQLiteDatabaseU0.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (iDelete > 0) {
                    zzicVar.a().w().c("Deleted application data. app, records", strO0, Integer.valueOf(iDelete));
                }
            } catch (SQLiteException e3) {
                zzavVarF0.f73997a.a().o().c("Error deleting application data. appId, error", zzgu.x(strO0), e3);
            }
            zzhVarJ0 = null;
        }
        if (zzhVarJ0 != null) {
            boolean z2 = (zzhVarJ0.F0() == -2147483648L || zzhVarJ0.F0() == zzrVar.f74509k) ? false : true;
            String strD0 = zzhVarJ0.D0();
            if (z2 || ((zzhVarJ0.F0() != -2147483648L || strD0 == null || strD0.equals(zzrVar.f74502c)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strD0);
                zzbg zzbgVar = new zzbg("_au", new zzbe(bundle), "auto", j3);
                if (B0().H(null, zzfy.f73630d1)) {
                    j(zzbgVar, zzrVar);
                } else {
                    k(zzbgVar, zzrVar);
                }
            }
        }
    }

    final void o(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        b().h();
        O0();
        com.google.android.gms.internal.measurement.zzgx zzgxVarZzr = com.google.android.gms.internal.measurement.zzha.zzr();
        byte[] bArrK = zzhVar.K();
        if (bArrK != null) {
            try {
                zzgxVarZzr = (com.google.android.gms.internal.measurement.zzgx) zzpk.W(zzgxVarZzr, bArrK);
            } catch (com.google.android.gms.internal.measurement.zzmr unused) {
                a().r().b("Failed to parse locally stored ad campaign info. appId", zzgu.x(zzhVar.o0()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals("_cmp")) {
                String str = (String) zzpk.v(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.v(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.v(zzhsVar, "gad_source", "");
                String[] strArrSplit = ((String) zzfy.f73642h1.b(null)).split(",");
                K0();
                if (!zzpk.s(zzhsVar, strArrSplit).isEmpty()) {
                    long jLongValue = ((Long) zzpk.v(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.u(zzhsVar, "_cis"))) {
                        if (jLongValue > zzgxVarZzr.zzo()) {
                            if (str.isEmpty()) {
                                zzgxVarZzr.zzj();
                            } else {
                                zzgxVarZzr.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzgxVarZzr.zzl();
                            } else {
                                zzgxVarZzr.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzgxVarZzr.zzn();
                            } else {
                                zzgxVarZzr.zzm(str3);
                            }
                            zzgxVarZzr.zzp(jLongValue);
                            zzgxVarZzr.zzs();
                            zzgxVarZzr.zzt(J(zzhsVar));
                        }
                    } else if (jLongValue > zzgxVarZzr.zzg()) {
                        if (str.isEmpty()) {
                            zzgxVarZzr.zzb();
                        } else {
                            zzgxVarZzr.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzgxVarZzr.zzd();
                        } else {
                            zzgxVarZzr.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzgxVarZzr.zzf();
                        } else {
                            zzgxVarZzr.zze(str3);
                        }
                        zzgxVarZzr.zzh(jLongValue);
                        zzgxVarZzr.zzq();
                        zzgxVarZzr.zzr(J(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzgxVarZzr.zzbc()).equals(com.google.android.gms.internal.measurement.zzha.zzs())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzgxVarZzr.zzbc());
        }
        zzhVar.J(((com.google.android.gms.internal.measurement.zzha) zzgxVarZzr.zzbc()).zzcc());
        if (zzhVar.A()) {
            F0().K0(zzhVar, false, false);
        }
        if (B0().H(null, zzfy.f73639g1)) {
            F0().z0(zzhVar.o0(), "_lgclid");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.gms.measurement.internal.zzh o0(com.google.android.gms.measurement.internal.zzr r13) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.o0(com.google.android.gms.measurement.internal.zzr):com.google.android.gms.measurement.internal.zzh");
    }

    final String p(zzjl zzjlVar) {
        if (!zzjlVar.o(zzjk.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        N0().q0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final String p0(zzr zzrVar) {
        try {
            return (String) b().r(new zzoz(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e3) {
            a().o().c("Failed to get app instance id. appId", zzgu.x(zzrVar.f74500a), e3);
            return null;
        }
    }

    final void q(List list) {
        Preconditions.a(!list.isEmpty());
        if (this.f74456y != null) {
            a().o().a("Set uploading progress before finishing the previous upload");
        } else {
            this.f74456y = new ArrayList(list);
        }
    }

    final List q0(zzr zzrVar, Bundle bundle) {
        b().h();
        zzqp.zza();
        zzal zzalVarB0 = B0();
        String str = zzrVar.f74500a;
        if (!zzalVarB0.H(str, zzfy.Q0) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    a().o().a("Uri sources and timestamps do not match");
                } else {
                    for (int i3 = 0; i3 < intArray.length; i3++) {
                        zzav zzavVarF0 = F0();
                        int i4 = intArray[i3];
                        long j3 = longArray[i3];
                        Preconditions.g(str);
                        zzavVarF0.h();
                        zzavVarF0.j();
                        try {
                            int iDelete = zzavVarF0.u0().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i4), String.valueOf(j3)});
                            zzgs zzgsVarW = zzavVarF0.f73997a.a().w();
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            zzgsVarW.d(sb.toString(), str, Integer.valueOf(i4), Long.valueOf(j3));
                        } catch (SQLiteException e3) {
                            zzavVarF0.f73997a.a().o().c("Error pruning trigger URIs. appId", zzgu.x(str), e3);
                        }
                    }
                }
            }
        }
        zzav zzavVarF02 = F0();
        String str2 = zzrVar.f74500a;
        Preconditions.g(str2);
        zzavVarF02.h();
        zzavVarF02.j();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzavVarF02.u0().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new zzoh(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e4) {
                zzavVarF02.f73997a.a().o().c("Error querying trigger uris. appId", zzgu.x(str2), e4);
                arrayList = Collections.EMPTY_LIST;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.database.Cursor] */
    final void r() {
        zzav zzavVarF0;
        long jN;
        SQLiteException e3;
        zzh zzhVarJ0;
        b().h();
        O0();
        this.f74453v = true;
        try {
            zzic zzicVar = this.f74443l;
            zzicVar.c();
            Boolean boolX = zzicVar.J().x();
            if (boolX == null) {
                a().r().a("Upload data called on the client side before use of service was decided");
            } else if (boolX.booleanValue()) {
                a().o().a("Upload called in the client side when service should be used");
            } else if (this.f74446o > 0) {
                R();
            } else {
                b().h();
                if (this.f74456y != null) {
                    a().w().a("Uploading requested multiple times");
                } else if (E0().m()) {
                    ?? CurrentTimeMillis = e().currentTimeMillis();
                    ?? r7 = 0;
                    cursorRawQuery = null;
                    Cursor cursorRawQuery = null;
                    string = null;
                    string = null;
                    String string = null;
                    int iE = B0().E(null, zzfy.f73647j0);
                    B0();
                    long jN2 = CurrentTimeMillis - zzal.n();
                    for (int i3 = 0; i3 < iE && M(null, jN2); i3++) {
                    }
                    zzqp.zza();
                    b().h();
                    v0();
                    long jA = this.f74440i.f74334h.a();
                    if (jA != 0) {
                        a().v().b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(CurrentTimeMillis - jA)));
                    }
                    String strR = F0().r();
                    long j3 = -1;
                    if (TextUtils.isEmpty(strR)) {
                        try {
                            this.A = -1L;
                            zzavVarF0 = F0();
                            B0();
                            jN = CurrentTimeMillis - zzal.n();
                            zzavVarF0.h();
                            zzavVarF0.j();
                        } catch (Throwable th) {
                            th = th;
                            r7 = CurrentTimeMillis;
                        }
                        try {
                            CurrentTimeMillis = zzavVarF0.u0().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jN)});
                            try {
                                if (CurrentTimeMillis.moveToFirst()) {
                                    string = CurrentTimeMillis.getString(0);
                                } else {
                                    zzavVarF0.f73997a.a().w().a("No expired configs for apps with pending events");
                                }
                            } catch (SQLiteException e4) {
                                e3 = e4;
                                CurrentTimeMillis = CurrentTimeMillis;
                                zzavVarF0.f73997a.a().o().b("Error selecting expired configs", e3);
                                if (CurrentTimeMillis != 0) {
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    B(zzhVarJ0);
                                }
                                this.f74453v = false;
                                S();
                            }
                        } catch (SQLiteException e5) {
                            e3 = e5;
                            CurrentTimeMillis = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            if (r7 == 0) {
                                throw th;
                            }
                            throw th;
                        }
                        CurrentTimeMillis.close();
                        if (!TextUtils.isEmpty(string) && (zzhVarJ0 = F0().J0(string)) != null) {
                            B(zzhVarJ0);
                        }
                    } else {
                        if (this.A == -1) {
                            zzav zzavVarF02 = F0();
                            try {
                                try {
                                    cursorRawQuery = zzavVarF02.u0().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if (cursorRawQuery.moveToFirst()) {
                                        j3 = cursorRawQuery.getLong(0);
                                    }
                                } catch (SQLiteException e6) {
                                    zzavVarF02.f73997a.a().o().b("Error querying raw events", e6);
                                    if (cursorRawQuery != null) {
                                    }
                                    this.A = j3;
                                    s(strR, CurrentTimeMillis);
                                    this.f74453v = false;
                                    S();
                                }
                                cursorRawQuery.close();
                                this.A = j3;
                            } finally {
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                            }
                        }
                        s(strR, CurrentTimeMillis);
                    }
                } else {
                    a().w().a("Network not connected, ignoring upload request");
                    R();
                }
            }
            this.f74453v = false;
            S();
        } catch (Throwable th3) {
            this.f74453v = false;
            S();
            throw th3;
        }
    }

    final void r0(String str, zzaf zzafVar) {
        b().h();
        O0();
        zzav zzavVarF0 = F0();
        long j3 = zzafVar.f73383a;
        zzpj zzpjVarN = zzavVarF0.n(j3);
        if (zzpjVarN == null) {
            a().r().c("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j3));
            return;
        }
        String strE = zzpjVarN.e();
        if (zzafVar.f73384b != zzlr.SUCCESS.zza()) {
            if (zzafVar.f73384b == zzlr.BACKOFF.zza()) {
                Map map = this.E;
                zzpe zzpeVar = (zzpe) map.get(strE);
                if (zzpeVar == null) {
                    zzpeVar = new zzpe(this);
                    map.put(strE, zzpeVar);
                } else {
                    zzpeVar.a();
                }
                a().w().d("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, strE, Long.valueOf((zzpeVar.c() - e().currentTimeMillis()) / 1000));
            }
            zzav zzavVarF02 = F0();
            Long lValueOf = Long.valueOf(zzafVar.f73383a);
            zzavVarF02.w(lValueOf);
            a().w().c("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, lValueOf);
            return;
        }
        Map map2 = this.E;
        if (map2.containsKey(strE)) {
            map2.remove(strE);
        }
        zzav zzavVarF03 = F0();
        Long lValueOf2 = Long.valueOf(j3);
        zzavVarF03.q(lValueOf2);
        a().w().c("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, lValueOf2);
        long j4 = zzafVar.f73385c;
        if (j4 > 0) {
            zzav zzavVarF04 = F0();
            zzavVarF04.h();
            zzavVarF04.j();
            Long lValueOf3 = Long.valueOf(j4);
            Preconditions.m(lValueOf3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
            zzic zzicVar = zzavVarF04.f73997a;
            contentValues.put("creation_timestamp", Long.valueOf(zzicVar.e().currentTimeMillis()));
            try {
                if (zzavVarF04.u0().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j4), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                    zzicVar.a().r().c("Google Signal pending batch not updated. appId, rowId", str, lValueOf3);
                }
                a().w().c("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.f73385c));
                u(str);
            } catch (SQLiteException e3) {
                zzavVarF04.f73997a.a().o().d("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j4), e3);
                throw e3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00be, code lost:
    
        r22 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x045e A[PHI: r10 r16 r23
      0x045e: PHI (r10v39 java.util.List) = (r10v53 java.util.List), (r10v38 java.util.List) binds: [B:184:0x0484, B:176:0x045c] A[DONT_GENERATE, DONT_INLINE]
      0x045e: PHI (r16v7 java.util.List) = (r16v12 java.util.List), (r16v13 java.util.List) binds: [B:184:0x0484, B:176:0x045c] A[DONT_GENERATE, DONT_INLINE]
      0x045e: PHI (r23v12 android.database.Cursor) = (r23v18 android.database.Cursor), (r23v22 android.database.Cursor) binds: [B:184:0x0484, B:176:0x045c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b A[PHI: r0 r10 r23
      0x006b: PHI (r0v117 java.util.List) = (r0v8 java.util.List), (r0v141 java.util.List) binds: [B:108:0x022a, B:16:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x006b: PHI (r10v57 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v59 android.database.Cursor) binds: [B:108:0x022a, B:16:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x006b: PHI (r23v28 long) = (r23v2 long), (r23v29 long) binds: [B:108:0x022a, B:16:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0a05  */
    /* JADX WARN: Removed duplicated region for block: B:475:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void s(java.lang.String r33, long r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.s(java.lang.String, long):void");
    }

    final void s0(boolean z2) {
        R();
    }

    final boolean t(String str, String str2) {
        zzh zzhVarJ0 = F0().J0(str);
        if (zzhVarJ0 != null && N0().P(str, zzhVarJ0.l0())) {
            this.E.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.E.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.b();
    }

    public final void t0(String str, zzlu zzluVar) {
        b().h();
        String str2 = this.G;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.G = str;
            this.F = zzluVar;
        }
    }

    final void u(String str) {
        com.google.android.gms.internal.measurement.zzib zzibVarD;
        b().h();
        O0();
        this.f74453v = true;
        try {
            zzic zzicVar = this.f74443l;
            zzicVar.c();
            Boolean boolX = zzicVar.J().x();
            if (boolX == null) {
                a().r().a("Upload data called on the client side before use of service was decided");
            } else if (boolX.booleanValue()) {
                a().o().a("Upload called in the client side when service should be used");
            } else if (this.f74446o > 0) {
                R();
            } else if (!E0().m()) {
                a().w().a("Network not connected, ignoring upload request");
                R();
            } else if (F0().p(str)) {
                zzav zzavVarF0 = F0();
                Preconditions.g(str);
                zzavVarF0.h();
                zzavVarF0.j();
                List listO = zzavVarF0.o(str, zzoo.M(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = listO.isEmpty() ? null : (zzpj) listO.get(0);
                if (zzpjVar != null && (zzibVarD = zzpjVar.d()) != null) {
                    a().w().d("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.f(), zzpjVar.e());
                    byte[] bArrZzcc = zzibVarD.zzcc();
                    if (Log.isLoggable(a().z(), 2)) {
                        a().w().d("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrZzcc.length), K0().K(zzibVarD));
                    }
                    zzot zzotVarA = zzpjVar.a();
                    this.f74452u = true;
                    E0().n(str, zzotVarA, zzibVarD, new zzox(this, str, zzpjVar));
                }
            } else {
                a().w().b("[sgtm] Upload queue has no batches for appId", str);
            }
            this.f74453v = false;
            S();
        } catch (Throwable th) {
            this.f74453v = false;
            S();
            throw th;
        }
    }

    final /* synthetic */ void u0(zzph zzphVar) {
        b().h();
        this.f74442k = new zzhk(this);
        zzav zzavVar = new zzav(this);
        zzavVar.k();
        this.f74434c = zzavVar;
        B0().t((zzak) Preconditions.m(this.f74432a));
        zznn zznnVar = new zznn(this);
        zznnVar.k();
        this.f74440i = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.k();
        this.f74437f = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.k();
        this.f74439h = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.k();
        this.f74436e = zzokVar;
        this.f74435d = new zzhb(this);
        if (this.f74449r != this.f74450s) {
            a().o().c("Not all upload components initialized", Integer.valueOf(this.f74449r), Integer.valueOf(this.f74450s));
        }
        this.f74444m.set(true);
        a().w().a("UploadController is now fully initialized");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void v(java.lang.String r4, int r5, java.lang.Throwable r6, byte[] r7, com.google.android.gms.measurement.internal.zzpj r8) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzhz r0 = r3.b()
            r0.h()
            r3.O0()
            r0 = 0
            if (r7 != 0) goto L13
            byte[] r7 = new byte[r0]     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r4 = move-exception
            goto L9b
        L13:
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 == r1) goto L1c
            r1 = 204(0xcc, float:2.86E-43)
            if (r5 != r1) goto L5a
            r5 = r1
        L1c:
            if (r6 != 0) goto L5a
            com.google.android.gms.measurement.internal.zzav r6 = r3.F0()     // Catch: java.lang.Throwable -> L10
            long r7 = r8.c()     // Catch: java.lang.Throwable -> L10
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L10
            r6.q(r7)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgu r6 = r3.a()     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgs r6 = r6.w()     // Catch: java.lang.Throwable -> L10
            java.lang.String r7 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            r6.c(r7, r4, r5)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgz r5 = r3.E0()     // Catch: java.lang.Throwable -> L10
            boolean r5 = r5.m()     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L56
            com.google.android.gms.measurement.internal.zzav r5 = r3.F0()     // Catch: java.lang.Throwable -> L10
            boolean r5 = r5.p(r4)     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L56
            r3.u(r4)     // Catch: java.lang.Throwable -> L10
            goto L95
        L56:
            r3.R()     // Catch: java.lang.Throwable -> L10
            goto L95
        L5a:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L10
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L10
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L10
            int r7 = r1.length()     // Catch: java.lang.Throwable -> L10
            r2 = 32
            int r7 = java.lang.Math.min(r2, r7)     // Catch: java.lang.Throwable -> L10
            java.lang.String r7 = r1.substring(r0, r7)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgu r1 = r3.a()     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgs r1 = r1.t()     // Catch: java.lang.Throwable -> L10
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            if (r6 != 0) goto L80
            r6 = r7
        L80:
            r1.d(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzav r4 = r3.F0()     // Catch: java.lang.Throwable -> L10
            long r5 = r8.c()     // Catch: java.lang.Throwable -> L10
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            r4.w(r5)     // Catch: java.lang.Throwable -> L10
            r3.R()     // Catch: java.lang.Throwable -> L10
        L95:
            r3.f74452u = r0
            r3.S()
            return
        L9b:
            r3.f74452u = r0
            r3.S()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.v(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.zzpj):void");
    }

    final void w(String str, boolean z2, Long l3, Long l4) {
        zzh zzhVarJ0 = F0().J0(str);
        if (zzhVarJ0 != null) {
            zzhVarJ0.e0(z2);
            zzhVarJ0.g0(l3);
            zzhVarJ0.i0(l4);
            if (zzhVarJ0.A()) {
                F0().K0(zzhVarJ0, false, false);
            }
        }
    }

    final void x(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int iX;
        int iIndexOf;
        Set setF = D0().F(str);
        if (setF != null) {
            zzicVar.zzaw(setF);
        }
        if (D0().J(str)) {
            zzicVar.zzG();
        }
        if (D0().K(str)) {
            String strZzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
                zzicVar.zzE(strZzD.substring(0, iIndexOf));
            }
        }
        if (D0().L(str) && (iX = zzpk.X(zzicVar, "_id")) != -1) {
            zzicVar.zzr(iX);
        }
        if (D0().M(str)) {
            zzicVar.zzan();
        }
        if (D0().N(str)) {
            zzicVar.zzX();
            if (g(str).o(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.D;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.f74427b + B0().D(str, zzfy.f73653l0) < e().a()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.f74426a);
            }
        }
        if (D0().O(str)) {
            zzicVar.zzav();
        }
    }

    final /* synthetic */ zzic x0() {
        return this.f74443l;
    }

    final void y(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i3 = 0; i3 < zzicVar.zzc(); i3++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i3).zzcl();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.f74421a.zzar() >= B0().E(zzpcVar.f74421a.zzA(), zzfy.f73656m0)) {
                        int iE = B0().E(zzpcVar.f74421a.zzA(), zzfy.f73682z0);
                        String strL0 = null;
                        if (iE <= 0) {
                            if (B0().H(zzpcVar.f74421a.zzA(), zzfy.S0)) {
                                strL0 = N0().l0();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb("_tu");
                                zzhvVarZzn.zzd(strL0);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn2.zzb("_tr");
                            zzhvVarZzn2.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc());
                            zzoh zzohVarI = K0().I(zzpcVar.f74421a.zzA(), zzicVar, zzhrVar, strL0);
                            if (zzohVarI != null) {
                                a().w().c("Generated trigger URI. appId, uri", zzpcVar.f74421a.zzA(), zzohVarI.f74381a);
                                F0().K(zzpcVar.f74421a.zzA(), zzohVarI);
                                Deque deque = this.f74448q;
                                if (!deque.contains(zzpcVar.f74421a.zzA())) {
                                    deque.add(zzpcVar.f74421a.zzA());
                                }
                            }
                        } else if (F0().L0(h(), zzpcVar.f74421a.zzA(), false, false, false, false, false, false, true).f73425g > iE) {
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn3.zzb("_tnr");
                            zzhvVarZzn3.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn3.zzbc());
                        } else {
                            if (B0().H(zzpcVar.f74421a.zzA(), zzfy.S0)) {
                                strL0 = N0().l0();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn4.zzb("_tu");
                                zzhvVarZzn4.zzd(strL0);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbc());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_tr");
                            zzhvVarZzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbc());
                            zzoh zzohVarI2 = K0().I(zzpcVar.f74421a.zzA(), zzicVar, zzhrVar, strL0);
                            if (zzohVarI2 != null) {
                                a().w().c("Generated trigger URI. appId, uri", zzpcVar.f74421a.zzA(), zzohVarI2.f74381a);
                                F0().K(zzpcVar.f74421a.zzA(), zzohVarI2);
                                Deque deque2 = this.f74448q;
                                if (!deque2.contains(zzpcVar.f74421a.zzA())) {
                                    deque2.add(zzpcVar.f74421a.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc());
                }
            }
        }
    }

    final /* synthetic */ Deque y0() {
        return this.f74448q;
    }

    final void z(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        List listB = CollectionUtils.b("_o", "_sn", "_sc", "_si");
        long jY = (zzpp.N(zzhvVar.zza()) || zzpp.N(str)) ? B0().y(str2, true) : B0().x(str2, true);
        long jCodePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzppVarN0 = N0();
        String strZza = zzhvVar.zza();
        B0();
        String strQ = zzppVarN0.q(strZza, 40, true);
        if (jCodePointCount <= jY || listB.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", N0().q(zzhvVar.zzc(), B0().y(str2, true), true));
            return;
        }
        a().t().c("Param value is too long; discarded. Name, value length", strQ, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strQ);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    final /* synthetic */ void z0(long j3) {
        this.I = j3;
    }

    final void h0(zzr zzrVar) {
        long j3;
        long j4;
        zzbc zzbcVarV0;
        boolean z2;
        String str;
        PackageInfo packageInfoF;
        ApplicationInfo applicationInfoC;
        long j5;
        boolean z3;
        String str2 = vxrlPPpdv.kSBbGgsPY;
        b().h();
        O0();
        Preconditions.m(zzrVar);
        String str3 = zzrVar.f74500a;
        Preconditions.g(str3);
        if (X(zzrVar)) {
            zzh zzhVarJ0 = F0().J0(str3);
            if (zzhVarJ0 != null && TextUtils.isEmpty(zzhVarJ0.r0()) && !TextUtils.isEmpty(zzrVar.f74501b)) {
                zzhVarJ0.i(0L);
                F0().K0(zzhVarJ0, false, false);
                D0().B(str3);
            }
            if (!zzrVar.f74507i) {
                o0(zzrVar);
                return;
            }
            long jCurrentTimeMillis = zzrVar.f74511m;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = e().currentTimeMillis();
            }
            long j6 = jCurrentTimeMillis;
            int i3 = zzrVar.f74512n;
            if (i3 != 0 && i3 != 1) {
                a().r().c("Incorrect app type, assuming installed app. appId, appType", zzgu.x(str3), Integer.valueOf(i3));
                i3 = 0;
            }
            F0().r0();
            try {
                zzpn zzpnVarB0 = F0().B0(str3, "_npa");
                Boolean boolZ = Z(zzrVar);
                if (zzpnVarB0 != null && !"auto".equals(zzpnVarB0.f74485b)) {
                    j3 = j6;
                    j4 = 1;
                } else if (boolZ != null) {
                    zzpl zzplVar = new zzpl("_npa", j6, Long.valueOf(true != boolZ.booleanValue() ? 0L : 1L), "auto");
                    j4 = 1;
                    j3 = j6;
                    if (zzpnVarB0 == null || !zzpnVarB0.f74488e.equals(zzplVar.f74480d)) {
                        c0(zzplVar, zzrVar);
                    }
                } else {
                    j3 = j6;
                    j4 = 1;
                    if (zzpnVarB0 != null) {
                        d0("_npa", zzrVar);
                    }
                }
                if (B0().H(null, zzfy.f73627c1)) {
                    n0(zzrVar, zzrVar.E);
                } else {
                    n0(zzrVar, j3);
                }
                o0(zzrVar);
                if (i3 == 0) {
                    zzbcVarV0 = F0().v0(str3, "_f");
                    z2 = false;
                } else {
                    zzbcVarV0 = F0().v0(str3, "_v");
                    z2 = true;
                }
                if (zzbcVarV0 == null) {
                    long j7 = ((j3 / 3600000) + j4) * 3600000;
                    if (z2) {
                        long j8 = j3;
                        c0(new zzpl("_fvt", j8, Long.valueOf(j7), "auto"), zzrVar);
                        b().h();
                        O0();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.f74514p) {
                            bundle.putLong("_dac", 1L);
                        }
                        if (B0().H(null, zzfy.f73651k1)) {
                            bundle.putLong("_elt", e().currentTimeMillis());
                        }
                        j(new zzbg("_v", new zzbe(bundle), "auto", j8), zzrVar);
                    } else {
                        Long lValueOf = Long.valueOf(j7);
                        long j9 = j3;
                        c0(new zzpl("_fot", j9, lValueOf, "auto"), zzrVar);
                        b().h();
                        zzhk zzhkVar = (zzhk) Preconditions.m(this.f74442k);
                        if (str3 == null || str3.isEmpty()) {
                            str = "_elt";
                            zzhkVar.f73838a.a().s().a("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzic zzicVar = zzhkVar.f73838a;
                            zzicVar.b().h();
                            if (zzhkVar.a()) {
                                zzhj zzhjVar = new zzhj(zzhkVar, str3);
                                zzicVar.b().h();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                str = "_elt";
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzicVar.d().getPackageManager();
                                if (packageManager == null) {
                                    zzicVar.a().s().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzicVar.a().u().a("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                                        if (serviceInfo != null) {
                                            String str4 = serviceInfo.packageName;
                                            if (serviceInfo.name != null && "com.android.vending".equals(str4) && zzhkVar.a()) {
                                                try {
                                                    zzicVar.a().w().b("Install Referrer Service is", ConnectionTracker.b().a(zzicVar.d(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                } catch (RuntimeException e3) {
                                                    zzhkVar.f73838a.a().o().b("Exception occurred while binding to Install Referrer Service", e3.getMessage());
                                                }
                                            } else {
                                                zzicVar.a().r().a("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzicVar.a().u().a("Install Referrer Reporter is not available");
                                str = "_elt";
                            }
                        }
                        b().h();
                        O0();
                        Bundle bundle2 = new Bundle();
                        long j10 = j4;
                        bundle2.putLong("_c", j10);
                        bundle2.putLong("_r", j10);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong(str2, 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        bundle2.putLong("_et", j10);
                        if (zzrVar.f74514p) {
                            bundle2.putLong("_dac", j10);
                        }
                        String str5 = (String) Preconditions.m(zzrVar.f74500a);
                        zzav zzavVarF0 = F0();
                        Preconditions.g(str5);
                        zzavVarF0.h();
                        zzavVarF0.j();
                        long jZ = zzavVarF0.z(str5, "first_open_count");
                        zzic zzicVar2 = this.f74443l;
                        if (zzicVar2.d().getPackageManager() == null) {
                            a().o().b("PackageManager is null, first open report might be inaccurate. appId", zzgu.x(str5));
                        } else {
                            try {
                                packageInfoF = Wrappers.a(zzicVar2.d()).f(str5, 0);
                            } catch (PackageManager.NameNotFoundException e4) {
                                a().o().c("Package info is null, first open report might be inaccurate. appId", zzgu.x(str5), e4);
                                packageInfoF = null;
                            }
                            if (packageInfoF != null) {
                                long j11 = packageInfoF.firstInstallTime;
                                if (j11 != 0) {
                                    if (j11 != packageInfoF.lastUpdateTime) {
                                        if (!B0().H(null, zzfy.J0)) {
                                            bundle2.putLong("_uwa", 1L);
                                        } else if (jZ == 0) {
                                            bundle2.putLong("_uwa", 1L);
                                            jZ = 0;
                                        }
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    c0(new zzpl("_fi", j9, Long.valueOf(true != z3 ? 0L : 1L), "auto"), zzrVar);
                                }
                            }
                            try {
                                applicationInfoC = Wrappers.a(this.f74443l.d()).c(str5, 0);
                            } catch (PackageManager.NameNotFoundException e5) {
                                a().o().c("Application info is null, first open report might be inaccurate. appId", zzgu.x(str5), e5);
                                applicationInfoC = null;
                            }
                            if (applicationInfoC != null) {
                                if ((applicationInfoC.flags & 1) != 0) {
                                    j5 = 1;
                                    bundle2.putLong("_sys", 1L);
                                } else {
                                    j5 = 1;
                                }
                                if ((applicationInfoC.flags & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                                    bundle2.putLong("_sysu", j5);
                                }
                            }
                        }
                        if (jZ >= 0) {
                            bundle2.putLong(str2, jZ);
                        }
                        if (B0().H(null, zzfy.f73651k1)) {
                            bundle2.putLong(str, e().currentTimeMillis());
                        }
                        j(new zzbg("_f", new zzbe(bundle2), "auto", j9), zzrVar);
                    }
                } else {
                    long j12 = j3;
                    if (zzrVar.f74508j) {
                        j(new zzbg("_cd", new zzbe(new Bundle()), "auto", j12), zzrVar);
                    }
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                F0().t0();
                throw th;
            }
        }
    }

    final void Q0(zzr zzrVar) {
        boolean z2;
        b().h();
        O0();
        String str = zzrVar.f74500a;
        Preconditions.g(str);
        zzaz zzazVarG = zzaz.g(zzrVar.f74524z);
        a().w().c("Setting DMA consent for package", str, zzazVarG);
        b().h();
        O0();
        zzji zzjiVarC = zzaz.h(S0(str), 100).c();
        this.C.put(str, zzazVarG);
        F0().V(str, zzazVarG);
        zzji zzjiVarC2 = zzaz.h(S0(str), 100).c();
        b().h();
        O0();
        zzji zzjiVar = zzji.DENIED;
        boolean z3 = true;
        if (zzjiVarC == zzjiVar && zzjiVarC2 == zzji.GRANTED) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (zzjiVarC != zzji.GRANTED || zzjiVarC2 != zzjiVar) {
            z3 = false;
        }
        if (!z2 && !z3) {
            return;
        }
        a().w().b("Generated _dcu event for", str);
        Bundle bundle = new Bundle();
        if (F0().L0(h(), str, false, false, false, false, false, false, false).f73424f < B0().E(str, zzfy.f73658n0)) {
            bundle.putLong("_r", 1L);
            a().w().c(KrzujOtzIk.XzRyHoJ, str, Long.valueOf(F0().L0(h(), str, false, false, false, false, false, true, false).f73424f));
        }
        this.J.a(str, "_dcu", bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    final Bundle S0(String str) {
        ?? I;
        String str2;
        b().h();
        O0();
        if (D0().R(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzjlVarG = g(str);
        bundle.putAll(zzjlVarG.n());
        bundle.putAll(T0(str, R0(str), zzjlVarG, new zzan()).f());
        zzpn zzpnVarB0 = F0().B0(str, vfptEEmYY.XIlym);
        if (zzpnVarB0 != null) {
            I = zzpnVarB0.f74488e.equals(1L);
        } else {
            I = I(str, new zzan());
        }
        if (1 != I) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }
}
