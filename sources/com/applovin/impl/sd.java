package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.o2;
import com.applovin.impl.sd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class sd implements o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final sd f63033g = new c().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o2.a f63034h = new o2.a() { // from class: com.applovin.impl.y40
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return sd.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f63036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f63037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ud f63038d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f63039f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d implements o2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final o2.a f63055g = new o2.a() { // from class: com.applovin.impl.z40
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return sd.d.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f63056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f63057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f63058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f63059d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f63060f;

        private d(long j3, long j4, boolean z2, boolean z3, boolean z4) {
            this.f63056a = j3;
            this.f63057b = j4;
            this.f63058c = z2;
            this.f63059d = z3;
            this.f63060f = z4;
        }

        private static String a(int i3) {
            return Integer.toString(i3, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f63056a == dVar.f63056a && this.f63057b == dVar.f63057b && this.f63058c == dVar.f63058c && this.f63059d == dVar.f63059d && this.f63060f == dVar.f63060f;
        }

        public int hashCode() {
            long j3 = this.f63056a;
            int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
            long j4 = this.f63057b;
            return ((((((i3 + ((int) ((j4 >>> 32) ^ j4))) * 31) + (this.f63058c ? 1 : 0)) * 31) + (this.f63059d ? 1 : 0)) * 31) + (this.f63060f ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d a(Bundle bundle) {
            return new d(bundle.getLong(a(0), 0L), bundle.getLong(a(1), Long.MIN_VALUE), bundle.getBoolean(a(2), false), bundle.getBoolean(a(3), false), bundle.getBoolean(a(4), false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f63061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f63062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final fb f63063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f63064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f63065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f63066f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final db f63067g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final byte[] f63068h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private UUID f63069a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Uri f63070b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private fb f63071c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f63072d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f63073e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f63074f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private db f63075g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private byte[] f63076h;

            private a() {
                this.f63071c = fb.h();
                this.f63075g = db.h();
            }

            public e a() {
                return new e(this);
            }

            private a(e eVar) {
                this.f63069a = eVar.f63061a;
                this.f63070b = eVar.f63062b;
                this.f63071c = eVar.f63063c;
                this.f63072d = eVar.f63064d;
                this.f63073e = eVar.f63065e;
                this.f63074f = eVar.f63066f;
                this.f63075g = eVar.f63067g;
                this.f63076h = eVar.f63068h;
            }
        }

        private e(a aVar) {
            b1.b((aVar.f63074f && aVar.f63070b == null) ? false : true);
            this.f63061a = (UUID) b1.a(aVar.f63069a);
            this.f63062b = aVar.f63070b;
            this.f63063c = aVar.f63071c;
            this.f63064d = aVar.f63072d;
            this.f63066f = aVar.f63074f;
            this.f63065e = aVar.f63073e;
            this.f63067g = aVar.f63075g;
            this.f63068h = aVar.f63076h != null ? Arrays.copyOf(aVar.f63076h, aVar.f63076h.length) : null;
        }

        public byte[] b() {
            byte[] bArr = this.f63068h;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f63061a.equals(eVar.f63061a) && xp.a(this.f63062b, eVar.f63062b) && xp.a(this.f63063c, eVar.f63063c) && this.f63064d == eVar.f63064d && this.f63066f == eVar.f63066f && this.f63065e == eVar.f63065e && this.f63067g.equals(eVar.f63067g) && Arrays.equals(this.f63068h, eVar.f63068h);
        }

        public int hashCode() {
            int iHashCode = this.f63061a.hashCode() * 31;
            Uri uri = this.f63062b;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f63063c.hashCode()) * 31) + (this.f63064d ? 1 : 0)) * 31) + (this.f63066f ? 1 : 0)) * 31) + (this.f63065e ? 1 : 0)) * 31) + this.f63067g.hashCode()) * 31) + Arrays.hashCode(this.f63068h);
        }

        public a a() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class f implements o2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f63077g = new a().a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final o2.a f63078h = new o2.a() { // from class: com.applovin.impl.a50
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return sd.f.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f63079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f63080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f63081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f63082d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f63083f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f63084a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f63085b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private long f63086c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f63087d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private float f63088e;

            public a() {
                this.f63084a = -9223372036854775807L;
                this.f63085b = -9223372036854775807L;
                this.f63086c = -9223372036854775807L;
                this.f63087d = -3.4028235E38f;
                this.f63088e = -3.4028235E38f;
            }

            public f a() {
                return new f(this);
            }

            private a(f fVar) {
                this.f63084a = fVar.f63079a;
                this.f63085b = fVar.f63080b;
                this.f63086c = fVar.f63081c;
                this.f63087d = fVar.f63082d;
                this.f63088e = fVar.f63083f;
            }
        }

        public f(long j3, long j4, long j5, float f3, float f4) {
            this.f63079a = j3;
            this.f63080b = j4;
            this.f63081c = j5;
            this.f63082d = f3;
            this.f63083f = f4;
        }

        private static String a(int i3) {
            return Integer.toString(i3, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f63079a == fVar.f63079a && this.f63080b == fVar.f63080b && this.f63081c == fVar.f63081c && this.f63082d == fVar.f63082d && this.f63083f == fVar.f63083f;
        }

        public int hashCode() {
            long j3 = this.f63079a;
            long j4 = this.f63080b;
            int i3 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f63081c;
            int i4 = (i3 + ((int) ((j5 >>> 32) ^ j5))) * 31;
            float f3 = this.f63082d;
            int iFloatToIntBits = (i4 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f63083f;
            return iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
        }

        public a a() {
            return new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ f a(Bundle bundle) {
            return new f(bundle.getLong(a(0), -9223372036854775807L), bundle.getLong(a(1), -9223372036854775807L), bundle.getLong(a(2), -9223372036854775807L), bundle.getFloat(a(3), -3.4028235E38f), bundle.getFloat(a(4), -3.4028235E38f));
        }

        private f(a aVar) {
            this(aVar.f63084a, aVar.f63085b, aVar.f63086c, aVar.f63087d, aVar.f63088e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f63089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f63090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f63091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f63092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f63093e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f63094f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Object f63095g;

        private g(Uri uri, String str, e eVar, b bVar, List list, String str2, List list2, Object obj) {
            this.f63089a = uri;
            this.f63090b = str;
            this.f63091c = eVar;
            this.f63092d = list;
            this.f63093e = str2;
            this.f63094f = list2;
            this.f63095g = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f63089a.equals(gVar.f63089a) && xp.a((Object) this.f63090b, (Object) gVar.f63090b) && xp.a(this.f63091c, gVar.f63091c) && xp.a((Object) null, (Object) null) && this.f63092d.equals(gVar.f63092d) && xp.a((Object) this.f63093e, (Object) gVar.f63093e) && this.f63094f.equals(gVar.f63094f) && xp.a(this.f63095g, gVar.f63095g);
        }

        public int hashCode() {
            int iHashCode = this.f63089a.hashCode() * 31;
            String str = this.f63090b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            e eVar = this.f63091c;
            int iHashCode3 = (((iHashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 961) + this.f63092d.hashCode()) * 31;
            String str2 = this.f63093e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f63094f.hashCode()) * 31;
            Object obj = this.f63095g;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    private sd(String str, d dVar, g gVar, f fVar, ud udVar) {
        this.f63035a = str;
        this.f63036b = gVar;
        this.f63037c = fVar;
        this.f63038d = udVar;
        this.f63039f = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static sd a(Bundle bundle) {
        String str = (String) b1.a((Object) bundle.getString(a(0), ""));
        Bundle bundle2 = bundle.getBundle(a(1));
        f fVar = bundle2 == null ? f.f63077g : (f) f.f63078h.a(bundle2);
        Bundle bundle3 = bundle.getBundle(a(2));
        ud udVar = bundle3 == null ? ud.H : (ud) ud.I.a(bundle3);
        Bundle bundle4 = bundle.getBundle(a(3));
        return new sd(str, bundle4 == null ? new d(0L, Long.MIN_VALUE, false, false, false) : (d) d.f63055g.a(bundle4), null, fVar, udVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sd)) {
            return false;
        }
        sd sdVar = (sd) obj;
        return xp.a((Object) this.f63035a, (Object) sdVar.f63035a) && this.f63039f.equals(sdVar.f63039f) && xp.a(this.f63036b, sdVar.f63036b) && xp.a(this.f63037c, sdVar.f63037c) && xp.a(this.f63038d, sdVar.f63038d);
    }

    public int hashCode() {
        int iHashCode = this.f63035a.hashCode() * 31;
        g gVar = this.f63036b;
        return ((((((iHashCode + (gVar != null ? gVar.hashCode() : 0)) * 31) + this.f63037c.hashCode()) * 31) + this.f63039f.hashCode()) * 31) + this.f63038d.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f63040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f63041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f63042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f63043d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f63044e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f63045f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f63046g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f63047h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private e.a f63048i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List f63049j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f63050k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List f63051l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Object f63052m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private ud f63053n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private f.a f63054o;

        public c() {
            this.f63044e = Long.MIN_VALUE;
            this.f63048i = new e.a();
            List list = Collections.EMPTY_LIST;
            this.f63049j = list;
            this.f63051l = list;
            this.f63054o = new f.a();
        }

        public sd a() {
            g gVar;
            b1.b(this.f63048i.f63070b == null || this.f63048i.f63069a != null);
            Uri uri = this.f63041b;
            if (uri != null) {
                gVar = new g(uri, this.f63042c, this.f63048i.f63069a != null ? this.f63048i.a() : null, null, this.f63049j, this.f63050k, this.f63051l, this.f63052m);
            } else {
                gVar = null;
            }
            String str = this.f63040a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            d dVar = new d(this.f63043d, this.f63044e, this.f63045f, this.f63046g, this.f63047h);
            f fVarA = this.f63054o.a();
            ud udVar = this.f63053n;
            if (udVar == null) {
                udVar = ud.H;
            }
            return new sd(str2, dVar, gVar, fVarA, udVar);
        }

        public c b(String str) {
            this.f63040a = (String) b1.a((Object) str);
            return this;
        }

        private c(sd sdVar) {
            e.a aVar;
            this();
            d dVar = sdVar.f63039f;
            this.f63044e = dVar.f63057b;
            this.f63045f = dVar.f63058c;
            this.f63046g = dVar.f63059d;
            this.f63043d = dVar.f63056a;
            this.f63047h = dVar.f63060f;
            this.f63040a = sdVar.f63035a;
            this.f63053n = sdVar.f63038d;
            this.f63054o = sdVar.f63037c.a();
            g gVar = sdVar.f63036b;
            if (gVar != null) {
                this.f63050k = gVar.f63093e;
                this.f63042c = gVar.f63090b;
                this.f63041b = gVar.f63089a;
                this.f63049j = gVar.f63092d;
                this.f63051l = gVar.f63094f;
                this.f63052m = gVar.f63095g;
                e eVar = gVar.f63091c;
                if (eVar != null) {
                    aVar = eVar.a();
                } else {
                    aVar = new e.a();
                }
                this.f63048i = aVar;
            }
        }

        public c a(String str) {
            this.f63050k = str;
            return this;
        }

        public c a(Object obj) {
            this.f63052m = obj;
            return this;
        }

        public c a(Uri uri) {
            this.f63041b = uri;
            return this;
        }
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    public static sd a(Uri uri) {
        return new c().a(uri).a();
    }

    public c a() {
        return new c();
    }
}
