import 'package:cupertino_base/widget_popover.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'app_data.dart';

class LayoutPartCentral extends StatefulWidget {
  const LayoutPartCentral({super.key});
  

  @override
  LayoutPartCentralState createState() => LayoutPartCentralState();
}

class LayoutPartCentralState extends State<LayoutPartCentral> {
  final GlobalKey _settingsButtonKey = GlobalKey();
  Color colorTexto = Colors.black;
  void changeTextColor(Color newColor) {
    setState(() {
      colorTexto = newColor;
    });
  }

  
  @override
  Widget build(BuildContext context) {
    AppData appData = Provider.of<AppData>(context);

    return CupertinoPageScaffold(
        navigationBar: CupertinoNavigationBar(
          leading: Row(
            mainAxisSize: MainAxisSize.min,
            children: [
              CupertinoButton(
                  padding: const EdgeInsets.all(0.0),
                  onPressed: appData.toggleSidebarLeft,
                  child: Icon(
                    CupertinoIcons.sidebar_left,
                    color: appData.isSidebarLeftVisible
                        ? CupertinoColors.activeBlue
                        : CupertinoColors.black,
                    size: 24.0,
                    semanticLabel: 'Text to announce in accessibility modes',
                  )),
              const SizedBox(width: 16),
            ],
          ),
          middle: CupertinoButton(
            key: _settingsButtonKey,
            padding: const EdgeInsets.all(0.0),
            onPressed: () {
              WidgetPopover.showPopover(
                  context: context,
                  key: _settingsButtonKey,
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Column(
                      children: [
                        GestureDetector(
                          onTap: () {
                            changeTextColor(Colors.black);
                            WidgetPopover.hidePopover();
                          },
                          child: Text('Negro'),
                        ),
                        GestureDetector(
                          onTap: () {
                            changeTextColor(Colors.red);
                            WidgetPopover.hidePopover();
                          },
                          child:Text('Rojo'),
                        ),
                        GestureDetector(
                          onTap: () {
                            changeTextColor(Colors.green);
                            WidgetPopover.hidePopover();
                          },
                          child:Text('Verde'),
                        ),
                        GestureDetector(
                          onTap: () {
                            changeTextColor(Colors.blue);
                            WidgetPopover.hidePopover();
                          },
                          child:Text('Azul'),
                        ),
                      ],
                    ),
                  ));
            },
            child: const Icon(
              CupertinoIcons.settings,
              color: CupertinoColors.black,
              size: 24.0,
              semanticLabel: 'Text to announce in accessibility modes',
            ),
          ),
          trailing: CupertinoButton(
              padding: const EdgeInsets.all(0.0),
              onPressed: appData.toggleSidebarRight,
              child: Icon(
                CupertinoIcons.sidebar_right,
                color: appData.isSidebarRightVisible
                    ? CupertinoColors.activeBlue
                    : CupertinoColors.black,
                size: 24.0,
                semanticLabel: 'Text to announce in accessibility modes',
              )),
        ),
        child:  Padding(
          padding: EdgeInsets.only(top: 50.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [Text("Central",
            style: TextStyle(
                  color: colorTexto,
                ),
            )
            ],
          ),
        ));
  }

  
}
