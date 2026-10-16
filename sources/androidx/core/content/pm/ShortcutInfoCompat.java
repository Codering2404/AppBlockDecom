package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ShortcutInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f33841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f33842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f33843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Intent[] f33844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ComponentName f33845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    CharSequence f33846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    CharSequence f33847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    CharSequence f33848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    IconCompat f33849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Person[] f33850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Set f33851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    LocusIdCompat f33852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f33853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f33854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    PersistableBundle f33855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    long f33856p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    UserHandle f33857q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f33858r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f33859s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f33860t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f33861u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f33862v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f33863w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f33864x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f33865y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f33866z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api33Impl {
        static void a(ShortcutInfo.Builder builder, int i3) {
            builder.setExcludedFromSurfaces(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    ShortcutInfoCompat() {
    }

    private PersistableBundle a() {
        if (this.f33855o == null) {
            this.f33855o = new PersistableBundle();
        }
        Person[] personArr = this.f33850j;
        if (personArr != null && personArr.length > 0) {
            this.f33855o.putInt("extraPersonCount", personArr.length);
            int i3 = 0;
            while (i3 < this.f33850j.length) {
                PersistableBundle persistableBundle = this.f33855o;
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i4 = i3 + 1;
                sb.append(i4);
                persistableBundle.putPersistableBundle(sb.toString(), this.f33850j[i3].j());
                i3 = i4;
            }
        }
        LocusIdCompat locusIdCompat = this.f33852l;
        if (locusIdCompat != null) {
            this.f33855o.putString("extraLocusId", locusIdCompat.a());
        }
        this.f33855o.putBoolean("extraLongLived", this.f33853m);
        return this.f33855o;
    }

    static LocusIdCompat c(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return d(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return LocusIdCompat.d(shortcutInfo.getLocusId());
    }

    private static LocusIdCompat d(PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString("extraLocusId")) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    static Person[] e(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey("extraPersonCount")) {
            return null;
        }
        int i3 = persistableBundle.getInt("extraPersonCount");
        Person[] personArr = new Person[i3];
        int i4 = 0;
        while (i4 < i3) {
            StringBuilder sb = new StringBuilder();
            sb.append("extraPerson_");
            int i5 = i4 + 1;
            sb.append(i5);
            personArr[i4] = Person.a(persistableBundle.getPersistableBundle(sb.toString()));
            i4 = i5;
        }
        return personArr;
    }

    public String b() {
        return this.f33842b;
    }

    public int f() {
        return this.f33854n;
    }

    public boolean g(int i3) {
        return (i3 & this.f33866z) != 0;
    }

    public ShortcutInfo h() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f33841a, this.f33842b).setShortLabel(this.f33846f).setIntents(this.f33844d);
        IconCompat iconCompat = this.f33849i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.p(this.f33841a));
        }
        if (!TextUtils.isEmpty(this.f33847g)) {
            intents.setLongLabel(this.f33847g);
        }
        if (!TextUtils.isEmpty(this.f33848h)) {
            intents.setDisabledMessage(this.f33848h);
        }
        ComponentName componentName = this.f33845e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.f33851k;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f33854n);
        PersistableBundle persistableBundle = this.f33855o;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.f33850j;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i3 = 0; i3 < length; i3++) {
                    personArr2[i3] = this.f33850j[i3].h();
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.f33852l;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.c());
            }
            intents.setLongLived(this.f33853m);
        } else {
            intents.setExtras(a());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.a(intents, this.f33866z);
        }
        return intents.build();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ShortcutInfoCompat f33867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f33868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set f33869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map f33870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Uri f33871e;

        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f33867a = shortcutInfoCompat;
            shortcutInfoCompat.f33841a = context;
            shortcutInfoCompat.f33842b = str;
        }

        public ShortcutInfoCompat a() {
            if (TextUtils.isEmpty(this.f33867a.f33846f)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            ShortcutInfoCompat shortcutInfoCompat = this.f33867a;
            Intent[] intentArr = shortcutInfoCompat.f33844d;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.f33868b) {
                if (shortcutInfoCompat.f33852l == null) {
                    shortcutInfoCompat.f33852l = new LocusIdCompat(shortcutInfoCompat.f33842b);
                }
                this.f33867a.f33853m = true;
            }
            if (this.f33869c != null) {
                ShortcutInfoCompat shortcutInfoCompat2 = this.f33867a;
                if (shortcutInfoCompat2.f33851k == null) {
                    shortcutInfoCompat2.f33851k = new HashSet();
                }
                this.f33867a.f33851k.addAll(this.f33869c);
            }
            if (this.f33870d != null) {
                ShortcutInfoCompat shortcutInfoCompat3 = this.f33867a;
                if (shortcutInfoCompat3.f33855o == null) {
                    shortcutInfoCompat3.f33855o = new PersistableBundle();
                }
                for (String str : this.f33870d.keySet()) {
                    Map map = (Map) this.f33870d.get(str);
                    this.f33867a.f33855o.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List list = (List) map.get(str2);
                        this.f33867a.f33855o.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.f33871e != null) {
                ShortcutInfoCompat shortcutInfoCompat4 = this.f33867a;
                if (shortcutInfoCompat4.f33855o == null) {
                    shortcutInfoCompat4.f33855o = new PersistableBundle();
                }
                this.f33867a.f33855o.putString("extraSliceUri", UriCompat.a(this.f33871e));
            }
            return this.f33867a;
        }

        public Builder b(Set set) {
            ArraySet arraySet = new ArraySet();
            arraySet.addAll(set);
            this.f33867a.f33851k = arraySet;
            return this;
        }

        public Builder c(IconCompat iconCompat) {
            this.f33867a.f33849i = iconCompat;
            return this;
        }

        public Builder d(Intent intent) {
            return e(new Intent[]{intent});
        }

        public Builder e(Intent[] intentArr) {
            this.f33867a.f33844d = intentArr;
            return this;
        }

        public Builder f(LocusIdCompat locusIdCompat) {
            this.f33867a.f33852l = locusIdCompat;
            return this;
        }

        public Builder g(boolean z2) {
            this.f33867a.f33853m = z2;
            return this;
        }

        public Builder h(int i3) {
            this.f33867a.f33854n = i3;
            return this;
        }

        public Builder i(CharSequence charSequence) {
            this.f33867a.f33846f = charSequence;
            return this;
        }

        public Builder(Context context, ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f33867a = shortcutInfoCompat;
            shortcutInfoCompat.f33841a = context;
            shortcutInfoCompat.f33842b = shortcutInfo.getId();
            shortcutInfoCompat.f33843c = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            shortcutInfoCompat.f33844d = (Intent[]) Arrays.copyOf(intents, intents.length);
            shortcutInfoCompat.f33845e = shortcutInfo.getActivity();
            shortcutInfoCompat.f33846f = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f33847g = shortcutInfo.getLongLabel();
            shortcutInfoCompat.f33848h = shortcutInfo.getDisabledMessage();
            int i3 = Build.VERSION.SDK_INT;
            shortcutInfoCompat.f33865y = shortcutInfo.getDisabledReason();
            shortcutInfoCompat.f33851k = shortcutInfo.getCategories();
            shortcutInfoCompat.f33850j = ShortcutInfoCompat.e(shortcutInfo.getExtras());
            shortcutInfoCompat.f33857q = shortcutInfo.getUserHandle();
            shortcutInfoCompat.f33856p = shortcutInfo.getLastChangedTimestamp();
            if (i3 >= 30) {
                shortcutInfoCompat.f33858r = shortcutInfo.isCached();
            }
            shortcutInfoCompat.f33859s = shortcutInfo.isDynamic();
            shortcutInfoCompat.f33860t = shortcutInfo.isPinned();
            shortcutInfoCompat.f33861u = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.f33862v = shortcutInfo.isImmutable();
            shortcutInfoCompat.f33863w = shortcutInfo.isEnabled();
            shortcutInfoCompat.f33864x = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.f33852l = ShortcutInfoCompat.c(shortcutInfo);
            shortcutInfoCompat.f33854n = shortcutInfo.getRank();
            shortcutInfoCompat.f33855o = shortcutInfo.getExtras();
        }
    }
}
