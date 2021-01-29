import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import './css/main.css';
import SearchTitle from "./components/SearchTitle";
import SearchHistory from "./components/SearchHistory";

class App extends Component {

    constructor(props){
        super(props);
    }

    componentDidMount() {

    }

    render() {
        return (
            <div className="row">
                <div className="col-sm">
                    <SearchTitle/>
                </div>
                <div className="col-sm">
                    <SearchHistory/>
                </div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
    }
};

const mapDispatchToProps = (dispatch) => {
    return {

    }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);