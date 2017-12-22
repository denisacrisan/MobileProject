
import React, { Component } from 'react';
import {
    AppRegistry,
    Platform,
    StyleSheet,
    Text,
    View,
    FlatList, ScrollView, TextInput, Button,Linking

} from 'react-native';
import {StackNavigator} from 'react-navigation'


var books=[
    {
      key:'1',
        title:'book1',
        author:'author1',
        yearOfPublication:'1990',
        publisher:'publisher1'
    },
    {
        key:'2',
        title:'book2',
        author:'author2',
        yearOfPublication:'2000',
        publisher:'publisher2'
    },
    {
        key:'3',
        title:'book3',
        author:'author3',
        yearOfPublication:'2010',
        publisher:'publisher3'
    }
]



export default class App extends Component {
  render() {
      return (<MyApplication/> )
  }
}


class BookList extends Component {

  render(){
      const {navigate} = this.props.navigation;
    return(
        <View style={styles.container}>
          <Text style={{ fontSize:30}}> Books </Text>
          <FlatList
                data = { books }
                renderItem={
                      ({item}) =>
                          <ScrollView>
                              <View style={styles.linearView} >
                                <Text style={styles.item} onPress={() => navigate('Details',{ book: item })
                                                                        } >{item.title} -> {item.author}</Text>
                              </View>
                          </ScrollView>
                      } />

          <View >
            <Button onPress={() => navigate('Email')}
                    title="Send Email"
                    color="#888888"  />
           
           </View>
        </View>
    )
  }

}


class Details extends Component{

    render(){
        const {state} = this.props.navigation;
        var book = state.params ? state.params.book : "<undefined>";
        return(
        <View style={styles.container}>

            <View  style={styles.singleItemDetails}>
              <Text>{book.title}</Text>
              <TextInput> {book.author} </TextInput>
              <TextInput> {book.yearOfPublication} </TextInput>
              <TextInput> {book.publisher} </TextInput>

              <ScrollView>
                     <TextInput style={{height: 100, width: 300, marginTop:10 }} multiline={true}> {book.storyline} </TextInput>
              </ScrollView>
            </View>
        </View>

        );
    }
}


class Email extends Component{

    render(){
      return(

        <View style={styles.container}>
          <Text> Email </Text>
          <TextInput onChangeText={(email)=>this.setState({email})} style={styles.fullWidth} />
          <Text> Content </Text>
          <TextInput onChangeText={(content)=>this.setState({content}) } style={styles.fullWidth} />
          <Button
              onPress={() => {
                                                subject = "Email sent from React Native";
                                                all = "mailto:" + this.state.email + "?subject=" + subject + "&body=" + this.state.content ;
                                                Linking.openURL(all)}}
              title="Send Email"
              color="#888888"
          />
        </View>


      )
    }
}

const MyApplication = StackNavigator({
    Home: {screen: BookList},
    Email: {screen: Email},
    Details: {screen: Details}
})

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#D4D4D4',
  },


    singleItemDetails:{
        marginTop:20
    },

    item: {

            padding: 10,
            fontSize: 18,
            height: 44,
        },

    linearView: {
            flexDirection:'row',
            padding:10,
        },
   bookList:{
    marginTop:50,
       marginBottom: 50,
       backgroundColor: '#F91111',

   },

  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },

  fullWidth: {
    width: 300,
  },
});