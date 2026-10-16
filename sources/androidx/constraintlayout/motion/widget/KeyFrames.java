package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyFrames {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static HashMap f32627b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f32628a = new HashMap();

    static {
        HashMap map = new HashMap();
        f32627b = map;
        try {
            map.put("KeyAttribute", KeyAttributes.class.getConstructor(null));
            f32627b.put("KeyPosition", KeyPosition.class.getConstructor(null));
            f32627b.put("KeyCycle", KeyCycle.class.getConstructor(null));
            f32627b.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));
            f32627b.put("KeyTrigger", KeyTrigger.class.getConstructor(null));
        } catch (NoSuchMethodException e3) {
            Log.e("KeyFrames", "unable to load", e3);
        }
    }

    public KeyFrames() {
    }

    public void a(MotionController motionController) {
        ArrayList arrayList = (ArrayList) this.f32628a.get(-1);
        if (arrayList != null) {
            motionController.b(arrayList);
        }
    }

    public void b(MotionController motionController) {
        ArrayList arrayList = (ArrayList) this.f32628a.get(Integer.valueOf(motionController.f32710c));
        if (arrayList != null) {
            motionController.b(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) this.f32628a.get(-1);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                Key key = (Key) obj;
                if (key.f(((ConstraintLayout.LayoutParams) motionController.f32709b.getLayoutParams()).f33111c0)) {
                    motionController.a(key);
                }
            }
        }
    }

    public void c(Key key) {
        if (!this.f32628a.containsKey(Integer.valueOf(key.f32584b))) {
            this.f32628a.put(Integer.valueOf(key.f32584b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) this.f32628a.get(Integer.valueOf(key.f32584b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList d(int i3) {
        return (ArrayList) this.f32628a.get(Integer.valueOf(i3));
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Exception e3;
        Key key;
        Constructor constructor;
        HashMap map;
        HashMap map2;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (f32627b.containsKey(name)) {
                        try {
                            constructor = (Constructor) f32627b.get(name);
                        } catch (Exception e4) {
                            Key key3 = key2;
                            e3 = e4;
                            key = key3;
                        }
                        if (constructor != null) {
                            key = (Key) constructor.newInstance(null);
                            try {
                                key.e(context, Xml.asAttributeSet(xmlPullParser));
                                c(key);
                            } catch (Exception e5) {
                                e3 = e5;
                                Log.e("KeyFrames", "unable to create ", e3);
                            }
                            key2 = key;
                        } else {
                            throw new NullPointerException("Keymaker for " + name + " not found");
                        }
                        Log.e("KeyFrames", "unable to create ", e3);
                        key2 = key;
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (key2 != null && (map2 = key2.f32587e) != null) {
                            ConstraintAttribute.i(context, xmlPullParser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && key2 != null && (map = key2.f32587e) != null) {
                        ConstraintAttribute.i(context, xmlPullParser, map);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }
}
