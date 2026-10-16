package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.share.internal.ShareConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Person {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CharSequence f33785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IconCompat f33786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f33787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f33788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f33789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f33790f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api22Impl {
        static Person a(PersistableBundle persistableBundle) {
            return new Builder().e(persistableBundle.getString("name")).f(persistableBundle.getString(ShareConstants.MEDIA_URI)).d(persistableBundle.getString("key")).b(persistableBundle.getBoolean("isBot")).c(persistableBundle.getBoolean("isImportant")).a();
        }

        static PersistableBundle b(Person person) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = person.f33785a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString(ShareConstants.MEDIA_URI, person.f33787c);
            persistableBundle.putString("key", person.f33788d);
            persistableBundle.putBoolean("isBot", person.f33789e);
            persistableBundle.putBoolean("isImportant", person.f33790f);
            return persistableBundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static android.app.Person a(Person person) {
            return new Person.Builder().setName(person.d()).setIcon(person.b() != null ? person.b().o() : null).setUri(person.e()).setKey(person.c()).setBot(person.f()).setImportant(person.g()).build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CharSequence f33791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        IconCompat f33792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f33793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f33794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f33795e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f33796f;

        public Person a() {
            return new Person(this);
        }

        public Builder b(boolean z2) {
            this.f33795e = z2;
            return this;
        }

        public Builder c(boolean z2) {
            this.f33796f = z2;
            return this;
        }

        public Builder d(String str) {
            this.f33794d = str;
            return this;
        }

        public Builder e(CharSequence charSequence) {
            this.f33791a = charSequence;
            return this;
        }

        public Builder f(String str) {
            this.f33793c = str;
            return this;
        }
    }

    Person(Builder builder) {
        this.f33785a = builder.f33791a;
        this.f33786b = builder.f33792b;
        this.f33787c = builder.f33793c;
        this.f33788d = builder.f33794d;
        this.f33789e = builder.f33795e;
        this.f33790f = builder.f33796f;
    }

    public static Person a(PersistableBundle persistableBundle) {
        return Api22Impl.a(persistableBundle);
    }

    public IconCompat b() {
        return this.f33786b;
    }

    public String c() {
        return this.f33788d;
    }

    public CharSequence d() {
        return this.f33785a;
    }

    public String e() {
        return this.f33787c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        String strC = c();
        String strC2 = person.c();
        return (strC == null && strC2 == null) ? Objects.equals(Objects.toString(d()), Objects.toString(person.d())) && Objects.equals(e(), person.e()) && Boolean.valueOf(f()).equals(Boolean.valueOf(person.f())) && Boolean.valueOf(g()).equals(Boolean.valueOf(person.g())) : Objects.equals(strC, strC2);
    }

    public boolean f() {
        return this.f33789e;
    }

    public boolean g() {
        return this.f33790f;
    }

    public android.app.Person h() {
        return Api28Impl.a(this);
    }

    public int hashCode() {
        String strC = c();
        return strC != null ? strC.hashCode() : Objects.hash(d(), e(), Boolean.valueOf(f()), Boolean.valueOf(g()));
    }

    public Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f33785a);
        IconCompat iconCompat = this.f33786b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.n() : null);
        bundle.putString(ShareConstants.MEDIA_URI, this.f33787c);
        bundle.putString("key", this.f33788d);
        bundle.putBoolean("isBot", this.f33789e);
        bundle.putBoolean("isImportant", this.f33790f);
        return bundle;
    }

    public PersistableBundle j() {
        return Api22Impl.b(this);
    }
}
