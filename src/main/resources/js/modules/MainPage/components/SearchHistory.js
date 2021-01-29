import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import '../css/main.css';

class SearchHistory extends Component {

    constructor(props){
        super(props);
        this.history = {};
    }

    render() {
        if(this.props.currentJob != null && this.props.currentJob.status === "DONE"){
            this.history[this.props.currentJob.webSiteUrl] = this.props.currentJob.title;
        }
        return (
            <div>
                <h4>Search History</h4>
                <ul>
                    {Object.keys(this.history).map((url, i) => (
                        <li className="search-history" key={i}>
                            <span className="bold">URL</span>: {url} <span className="bold">Title:</span> {this.history[url]}
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        currentJob: state.rootReducer.currentJob
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(SearchHistory);