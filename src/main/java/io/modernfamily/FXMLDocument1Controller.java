package io.modernfamily;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.SequentialTransition;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
//import static javafxapplication3.FXMLDocumentController.CountID;

/**
 * FXML Controller class
 *
 * @author baseerfaizan
 */
public class FXMLDocument1Controller implements Initializable {

    public int CID;
    @FXML
    private ImageView line1;
    @FXML
    private ImageView line2;
    @FXML
    private ImageView line3;
    @FXML
    private ImageView line4;
    @FXML
    private ImageView line5;
    @FXML
    private ImageView line6;
    @FXML
    private ImageView line7;
    @FXML
    private ImageView line8;
    @FXML
    private ImageView line9;
    @FXML
    private ImageView line10;
    @FXML
    private ImageView line11;
    @FXML
    private ImageView line12;
    @FXML
    private ImageView theMap;
    @FXML
    private ImageView theSkype;
    @FXML
    private Button btnx;
    @FXML
    private Button btny;
    @FXML
    private ImageView theCall;
    @FXML
    private Button btnz;
    @FXML
    private ImageView theCar2;
    @FXML
    private ImageView theCar3;
    @FXML
    private ImageView theCar4;
    @FXML
    private ImageView theCar1;
    @FXML
    private ImageView thePerson;
    @FXML
    private ImageView notif;

    /**
     * Initializes the controller class.
     */
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("View is now loaded!");
        FXMLDocumentController log = new FXMLDocumentController();
        CID = log.getCountID();
        System.out.println(CID);
        next();
    }

    public void next() {
        boolean onMaps = false;
        boolean onSkype = false;
        boolean onCall = false;
        boolean carSpeaker = false;

        if (!onMaps) {
            thePerson.setVisible(true);
            theMap.setVisible(false);
            theSkype.setVisible(false);
            theCar2.setVisible(false);
            theCar1.setVisible(false);
            theCar3.setVisible(false);
            theCar4.setVisible(false);
            theCall.setVisible(false);
            notif.setVisible(false);
            nextTaskX();
        }
    }

    public void nextTaskX() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(true);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                nextTask1();
            }
        });
        new Thread(sleeper).start();

    }

    @FXML
    public void letask(ActionEvent event) {
        if (event.getSource() == btnx) {
            theMap.setVisible(false);
            theSkype.setVisible(true);
            theCall.setVisible(false);
            theCar2.setVisible(false);
            theCar1.setVisible(false);
            theCar3.setVisible(false);
            theCar4.setVisible(false);
            thePerson.setVisible(false);
            notif.setVisible(false);
            nextTask();
        }
        if (event.getSource() == btny) {
            theMap.setVisible(false);
            theSkype.setVisible(false);
            theCall.setVisible(true);
            theCar2.setVisible(false);
            theCar1.setVisible(false);
            theCar3.setVisible(false);
            theCar4.setVisible(false);
            notif.setVisible(true);
            thePerson.setVisible(false);
        }
        if (event.getSource() == btnz) {
            theMap.setVisible(true);
            theSkype.setVisible(false);
            theCall.setVisible(false);
            theCar2.setVisible(false);
            theCar1.setVisible(false);
            theCar3.setVisible(false);
            theCar4.setVisible(false);
            notif.setVisible(false);
            thePerson.setVisible(false);
        }
    }

    public void nextTask() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(true);
                line1.setVisible(false);
                nextTask1();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask1() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(true);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                nextTask2();

            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask2() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(true);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                nextTask3();

            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask3() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(true);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                nextTask4();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask4() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(true);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                nextTask5();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask5() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(true);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                nextTask6();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask6() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(true);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                nextTask7();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask7() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(true);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                nextTask8();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask8() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(true);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                nextTask9();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask9() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(true);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                line10.setVisible(false);
                nextTask10();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask10() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(true);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                line10.setVisible(false);
                line11.setVisible(false);
                nextTask11();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask11() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(true);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                line10.setVisible(false);
                line11.setVisible(false);
                line12.setVisible(false);
                nextTask12();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask12() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(true);
                thePerson.setVisible(false);
                notif.setVisible(true);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                line10.setVisible(false);
                line11.setVisible(false);
                line12.setVisible(false);
                nextTask13();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask13() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(true);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(false);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                line10.setVisible(false);
                line11.setVisible(false);
                line12.setVisible(false);
                nextTask14();
            }
        });
        new Thread(sleeper).start();

    }

    public void nextTask14() {
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
            public void handle(WorkerStateEvent event) {
                theMap.setVisible(false);
                theSkype.setVisible(false);
                theCall.setVisible(false);
                thePerson.setVisible(true);
                notif.setVisible(false);

                theCar1.setVisible(false);
                theCar3.setVisible(false);
                theCar4.setVisible(false);
                theCar2.setVisible(false);
                line1.setVisible(false);
                line2.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line5.setVisible(false);
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                line9.setVisible(false);
                line10.setVisible(false);
                line11.setVisible(false);
                line12.setVisible(false);
                //nextTask14();
            }
        });
        new Thread(sleeper).start();

    }

}

