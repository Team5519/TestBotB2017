package org.usfirst.frc.team5519.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraVision extends Subsystem {

    public static final String CAM_ID = "cam1";
    public static int camCounter = 0;
    public static final int IMAGE_QUALITY = 100;
    public static final int SAVE_IMAGE_QUALITY = 100;
    public static final String IMAGE_PATH = "/images/test.jpg";
    public static final int DISTANCE_CHANNEL = 0;
    public static final int CAMERA_SESSION = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
    //this may need to change to "cam1" depending if using test board or multiple cameras
    public static final Image FRAME = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

    int session;
    Image frame;
    NIVision.RawData colorTable;
    CameraServer server;


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

    public void init()
    {
        frame = CameraVision.FRAME;
        // the camera name (ex "cam0") can be found through the roborio web interface
        session = CameraVision.CAMERA_SESSION;
        NIVision.IMAQdxConfigureGrab(session);
        
        colorTable = new NIVision.RawData();
    }

    public void saveImage() {
        NIVision.IMAQdxStartAcquisition(session);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

        //loops in autonomous

            NIVision.IMAQdxGrab(session, frame, 1);
            NIVision.imaqWriteJPEGFile(frame, "/images/test.jpg", 200, colorTable);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            CameraServer.getInstance().setImage(frame);

            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
        
            NIVision.IMAQdxStopAcquisition(session);
    }
    
    public void sendImage()
    {
    	NIVision.IMAQdxGrab(session, frame, 1);
    	
    	CameraServer.getInstance().setImage(frame);

        /** robot code here! **/
        //Timer.delay(0.005);		// wait for a motor update time
    }
    
    public void end()
    {
    	//NIVision.IMAQdxStopAcquisition(session);
    }

    public void test() {
    }

}
