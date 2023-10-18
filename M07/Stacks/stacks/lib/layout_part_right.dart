import 'package:flutter/cupertino.dart';
import 'package:provider/provider.dart';
import 'app_data.dart';

class LayoutPartright extends StatefulWidget {
  const LayoutPartright({Key? key}) : super(key: key);

  @override
  LayoutPartLeftState createState() => LayoutPartLeftState();
}

class LayoutPartLeftState extends State<LayoutPartright> {
  @override
  Widget build(BuildContext context) {
    AppData appData = Provider.of<AppData>(context);
    return Container(
      width: double.infinity, // Expandeix l'ample
      height: double.infinity, // Expandeix l'alt
      child: const Column(
        crossAxisAlignment:
            CrossAxisAlignment.start, // Alinea els elements a l'esquerra
        children: [Text("Right")],
      ),
    );
  }
}
