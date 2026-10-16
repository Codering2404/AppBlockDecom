package com.google.android.gms.internal.gtm;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.facebook.LegacyTokenHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzcu extends zzbt {
    final zzct zza;

    public zzcu(zzbx zzbxVar, zzct zzctVar) {
        super(zzbxVar);
        this.zza = zzctVar;
    }

    private final zzcs zzb(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals(ViewHierarchyConstants.SCREEN_NAME_KEY)) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(strTrim)) {
                            this.zza.zzb(attributeValue, strTrim);
                        }
                    } else if (lowerCase.equals(LegacyTokenHelper.TYPE_STRING)) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && strTrim2 != null) {
                            this.zza.zze(attributeValue2, strTrim2);
                        }
                    } else if (lowerCase.equals(LegacyTokenHelper.TYPE_BOOLEAN)) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(strTrim3)) {
                            try {
                                this.zza.zzc(attributeValue3, Boolean.parseBoolean(strTrim3));
                            } catch (NumberFormatException e3) {
                                zzS("Error parsing bool configuration value", strTrim3, e3);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String strTrim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(strTrim4)) {
                            try {
                                this.zza.zzd(attributeValue4, Integer.parseInt(strTrim4));
                            } catch (NumberFormatException e4) {
                                zzS("Error parsing int configuration value", strTrim4, e4);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e5) {
            zzJ("Error parsing tracker configuration file", e5);
        } catch (XmlPullParserException e6) {
            zzJ("Error parsing tracker configuration file", e6);
        }
        return this.zza.zza();
    }

    public final zzcs zza(int i3) {
        try {
            return zzb(zzt().zzb().getResources().getXml(i3));
        } catch (Resources.NotFoundException e3) {
            zzR("inflate() called with unknown resourceId", e3);
            return null;
        }
    }
}
