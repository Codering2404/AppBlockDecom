package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ClientSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Account f71952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f71953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f71954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f71955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f71956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f71957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f71958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f71959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SignInOptions f71960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f71961j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Account f71962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArraySet f71963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f71964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f71965d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final SignInOptions f71966e = SignInOptions.f74552k;

        public ClientSettings a() {
            return new ClientSettings(this.f71962a, this.f71963b, null, 0, null, this.f71964c, this.f71965d, this.f71966e, false);
        }

        public Builder b(String str) {
            this.f71964c = str;
            return this;
        }

        public final Builder c(Collection collection) {
            if (this.f71963b == null) {
                this.f71963b = new ArraySet();
            }
            this.f71963b.addAll(collection);
            return this;
        }

        public final Builder d(Account account) {
            this.f71962a = account;
            return this;
        }

        public final Builder e(String str) {
            this.f71965d = str;
            return this;
        }
    }

    public ClientSettings(Account account, Set set, Map map, int i3, View view, String str, String str2, SignInOptions signInOptions, boolean z2) {
        this.f71952a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f71953b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f71955d = map;
        this.f71957f = view;
        this.f71956e = i3;
        this.f71958g = str;
        this.f71959h = str2;
        this.f71960i = signInOptions == null ? SignInOptions.f74552k : signInOptions;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((zab) it.next()).f72040a);
        }
        this.f71954c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f71952a;
    }

    public String b() {
        Account account = this.f71952a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account c() {
        Account account = this.f71952a;
        return account != null ? account : new Account(BaseGmsClient.DEFAULT_ACCOUNT, "com.google");
    }

    public Set d() {
        return this.f71954c;
    }

    public Set e(Api api) {
        zab zabVar = (zab) this.f71955d.get(api);
        if (zabVar == null || zabVar.f72040a.isEmpty()) {
            return this.f71953b;
        }
        HashSet hashSet = new HashSet(this.f71953b);
        hashSet.addAll(zabVar.f72040a);
        return hashSet;
    }

    public String f() {
        return this.f71958g;
    }

    public Set g() {
        return this.f71953b;
    }

    public final SignInOptions h() {
        return this.f71960i;
    }

    public final Integer i() {
        return this.f71961j;
    }

    public final String j() {
        return this.f71959h;
    }

    public final Map k() {
        return this.f71955d;
    }

    public final void l(Integer num) {
        this.f71961j = num;
    }
}
